package ui;

import model.Block;
import model.BlockCollection;
import model.Board;

import java.awt.*;
import java.util.Scanner;

public class TetrisApp {
    private Board board;
    private Block controlBlock;
    private BlockCollection fixedBlocks;
    private Scanner input;

    public TetrisApp() {
        playTetris();
    }

    private void playTetris() {
        boolean continuePlaying = true;
        String move;

        init();

        while (continuePlaying) {
            displayMoves();
            move = input.next();

            move = move.toLowerCase();

            if (move.equals("quit")) {
                continuePlaying = false;
            } else {
                doMove(move);
            }
        }

        System.out.println("\n Game Over. Your score was: " + board.getFixedBlocks().getScore());
    }

    private void init() {
        board = new Board();
        board.newBlock();
        controlBlock = board.getCurBlock();
        fixedBlocks = board.getFixedBlocks();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    private void displayMoves() {
        System.out.println("\nChoose a move by typing it out:");
        System.out.println("Select from:");
        System.out.println("Down - moves the current block down 1 row.");
        System.out.println("Left - moves the current block leftward 1 column.");
        System.out.println("Right - moves the current block rightward 1 column.");
        System.out.println("Rotate Right - rotates the current block clockwise 90°.");
        System.out.println("Rotate Left - rotates the current block anti-clockwise 90°.");
        System.out.println("Place Block - fixes the current block in place, and creates a new ");
        System.out.println("random block for you to control.");
    }

    private void doMove(String move) {
        if (move.equals("down")) {
            Point newAnchorPoint = controlBlock.downOneLine();
            board.tryNextCoordinates(newAnchorPoint);
        } else if (move.equals("left")) {
            Point newAnchorPoint = controlBlock.moveLeft();
            board.tryNextCoordinates(newAnchorPoint);
        } else if (move.equals("right")) {
            Point newAnchorPoint = controlBlock.moveRight();
            board.tryNextCoordinates(newAnchorPoint);
        } else if (move.equals("rotate left")) {
            Point[] newCoords = controlBlock.rotateLeft();
            board.tryNextCoordinates(newCoords, "left");
        } else if (move.equals("rotate right")) {
            Point[] newCoords = controlBlock.rotateRight();
            board.tryNextCoordinates(newCoords, "right");
        } else if (move.equals("place block")) {
            fixedBlocks.fixBlock(controlBlock);
            System.out.println(controlBlock.getAnchorPoint());
            board.newBlock();
            controlBlock = board.getCurBlock();
        } else {
            System.out.println("Chosen move is not in the list of moves. Try again.");
        }

    }
}

