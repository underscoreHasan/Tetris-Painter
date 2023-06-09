package persistence;

import model.Block;
import model.BlockHeap;
import model.shapedblocks.*;

import java.awt.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads Block from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Block readBlock() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseBlock(jsonObject);
    }

    // EFFECTS: reads BlockHeap from file and returns it;
    // throws IOException if an error occurs reading data from file
    public BlockHeap readBlockHeap() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseBlockHeap(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses Block from JSON object and returns it
    private Block parseBlock(JSONObject jsonObject) {
        JSONObject jsonControlBlock = jsonObject.getJSONObject("controlBlock");
        int anchorPointX = jsonControlBlock.getInt("anchorPointX");
        int anchorPointY = jsonControlBlock.getInt("anchorPointY");
        int rotationState = jsonControlBlock.getInt("rotationState");
        String blockType = jsonControlBlock.getString("blockType");
        Block block = constructBlock(anchorPointX, anchorPointY, rotationState, blockType);
        return block;
    }

    // EFFECTS: parses BlockHeap from JSON object and returns it
    private BlockHeap parseBlockHeap(JSONObject jsonObject) {
        BlockHeap fixedBlocks = new BlockHeap();
        addBlocks(fixedBlocks, jsonObject);
        return fixedBlocks;
    }

    // MODIFIES: fixedBlocks
    // EFFECTS: parses Blocks from JSON object and adds them to workroom
    private void addBlocks(BlockHeap fixedBlocks, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("blockList");
        for (Object json : jsonArray) {
            JSONObject nextBlock = (JSONObject) json;
            addBlock(fixedBlocks, nextBlock);
        }
    }

    // MODIFIES: fixedBlocks
    // EFFECTS: parses Block from JSON object and adds it to workroom
    private void addBlock(BlockHeap fixedBlocks, JSONObject jsonObject) {
        int anchorPointX = jsonObject.getInt("anchorPointX");
        int anchorPointY = jsonObject.getInt("anchorPointY");
        int rotationState = jsonObject.getInt("rotationState");
        String blockType = jsonObject.getString("blockType");
        Block fixedBlock = constructBlock(anchorPointX, anchorPointY, rotationState, blockType);
        fixedBlocks.fixBlock(fixedBlock);
    }

    // MODIFIES: fixedBlock
    // EFFECTS: constructs a block and sets its properties to those passed as the parameters
    @SuppressWarnings("methodlength")
    private Block constructBlock(int anchorPointX, int anchorPointY, int rotationState, String blockType) {
        Block block = null;

        switch (blockType) {
            case "I":
                block = new BlockI();
                break;
            case "J":
                block = new BlockJ();
                break;
            case "L":
                block = new BlockL();
                break;
            case "O":
                block = new BlockO();
                break;
            case "S":
                block = new BlockS();
                break;
            case "T":
                block = new BlockT();
                break;
            default:
                block = new BlockZ();
        }

        block.setAnchorPoint(anchorPointX, anchorPointY);
        block.setRotationState(rotationState);

        return block;
    }
}
