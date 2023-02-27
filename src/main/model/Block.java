package model;

import java.awt.*;

public abstract class Block {

    private Point[][] coordStates;
    private Color color;
    private Point[] orientation = new Point[4];
    private Point anchorPoint = new Point();
    private int rotationState;

    // REQUIRES: anchorPoint.x > 0 && anchorPoint.y > 0
    // EFFECTS: returns the coordinates of anchorPoint dropped by 1 line
    public Point downOneLine() {
        return new Point(anchorPoint.x, anchorPoint.y + 1);
    }

    // REQUIRES: anchorPoint.x > 0 && anchorPoint.y > 0
    // EFFECTS: returns the coordinates of anchorPoint moved right 1 column
    public Point moveRight() {
        return new Point(anchorPoint.x + 1, anchorPoint.y);
    }

    // REQUIRES: anchorPoint.x > 0 && anchorPoint.y > 0
    // EFFECTS: returns the coordinates of anchorPoint moved left 1 column
    public Point moveLeft() {
        return new Point(anchorPoint.x - 1, anchorPoint.y);
    }

    // REQUIRES: anchorPoint.x > 0 && anchorPoint.y > 0
    // EFFECTS: returns the orientation of the block if rotated anticlockwise 90° around the anchor point
    public Point[] rotateLeft() {
        if (rotationState - 1 < 0) {
            return this.coordStates[3];
        } else {
            return this.coordStates[rotationState - 1];
        }
    }

    // REQUIRES: anchorPoint.x > 0 && anchorPoint.y > 0
    // EFFECTS: returns the orientation of the block if rotated clockwise 90° around the anchor point
    public Point[] rotateRight() {
        if (rotationState + 1 > 3) {
            return this.coordStates[0];
        } else {
            return this.coordStates[rotationState + 1];
        }
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

    // REQUIRES: 0 <= i <= 3
    // MODIFIES: this
    // EFFECTS: Copies the array of Points at index i in this.coordStates into this.orientation
    public void setOrientation(int i) {
        System.arraycopy(this.coordStates[i], 0, this.orientation, 0,4);;
    }

    public int getRotationState() {
        return rotationState;
    }

    public void setRotationState(int rotationState) {
        this.rotationState = rotationState;
    }

    // MODIFIES: this
    // EFFECTS: Increments the rotationState by 1
    public void incRotationState() {
        int newState = rotationState + 1;

        if (newState > 3) {
            rotationState = 0;
        } else {
            rotationState = newState;
        }
    }

    // MODIFIES: this
    // EFFECTS: Decrements the rotationState by 1
    public void decRotationState() {
        int newState = rotationState - 1;

        if (newState < 0) {
            rotationState = 3;
        } else {
            rotationState = newState;
        }
    }
}
