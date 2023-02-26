package model;

import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public abstract class Block {

    private Point[][] coordStates;
    private Color color;
    private Point[] orientation;
    private Point anchorPoint;
    private int coordX = anchorPoint.x;
    private int coordY = anchorPoint.y;
    private int rotationState;

    // REQUIRES: checkCollision() is false
    // MODIFIES: this
    // EFFECTS: drops the block down 1 line by altering the anchorpoint
    public void downOneLine() {
        setAnchorPoint(coordX, coordY + 1);
    }

    // REQUIRES: checkCollision() is false
    // MODIFIES: this
    // EFFECTS: moves the block 1 to the right
    public void moveRight() {
        setAnchorPoint(coordX + 1, coordY);
    }

    // REQUIRES: checkCollision() is false
    // MODIFIES: this
    // EFFECTS: moves the block one to the left
    public void moveLeft() {
        setAnchorPoint(coordX - 1, coordY);
    }

    // REQUIRES: checkCollision() is false
    // MODIFIES: this
    // EFFECTS: rotates the block anticlockwise around the anchor point
    public void rotateLeft() {
        rotationState++;
        setOrientation(Math.abs(rotationState % 4));
    }

    // REQUIRES: checkCollision() is false
    // MODIFIES: this
    // EFFECTS: rotates the block clockwise around the anchor point
    public void rotateRight() {
        rotationState--;
        setOrientation(Math.abs(rotationState % 4));
    }

    public Point getAnchorPoint() {
        return anchorPoint;
    }

    public void setAnchorPoint(int coordX, int coordY) {
        anchorPoint.setLocation(coordX, coordY);
    }

    public Point[][] getCoordStates() {
        return coordStates;
    }

    public void setCoordStates(Point[][] coordStates) {
        this.coordStates = coordStates;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Point[] getOrientation() {
        return this.orientation;
    }

    public void setOrientation(int i) {
        System.arraycopy(this.coordStates[i], 0, this.orientation, 0,4);
        rotationState = i;
    }
}
