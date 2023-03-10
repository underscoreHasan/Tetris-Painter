package model;

import java.awt.*;

// The abstract class that represents all the generic information and behaviour of a Block. This can be
// considered a "shapeless" block that contains information such as color, it's central point(anchorPoint),
// it's color, a counter for its orientation(rotationState), etc. while specialized information such
// as the coordinates that define a Block's shape lives in the inherited classes for each shapedBlock.
public abstract class Block {

    private Point[][] coordStates;
    private Color color;
    private Point[] orientation = new Point[4];
    private Point anchorPoint = new Point();
    private int rotationState;

    // REQUIRES: anchorPoint.x > 0 && anchorPoint.y > 0
    // MODIFIES: this
    // EFFECTS: drops the block down 1 coordinate by altering the anchorPoint
    public void downOneLine() {
        setAnchorPoint(anchorPoint.x, anchorPoint.y + 1);
    }

    // REQUIRES: anchorPoint.x > 0 && anchorPoint.y > 0
    // MODIFIES: this
    // EFFECTS: moves the block 1 coordinate to the right by altering the anchorPoint
    public void moveRight() {
        setAnchorPoint(anchorPoint.x + 1, anchorPoint.y);
    }

    // REQUIRES: anchorPoint.x > 0 && anchorPoint.y > 0
    // MODIFIES: this
    // EFFECTS: moves the block 1 coordinate to the left by altering the anchorPoint
    public void moveLeft() {
        setAnchorPoint(anchorPoint.x - 1, anchorPoint.y);
    }

    // REQUIRES: anchorPoint.x > 0 && anchorPoint.y > 0
    // MODIFIES: this
    // EFFECTS: rotates the block anticlockwise around anchorPoint
    public void rotateLeft() {
        if (rotationState - 1 < 0) {
            setRotationState(3);
            setOrientation(3);
        } else {
            setRotationState(rotationState - 1);
            setOrientation(rotationState); // since rotationState has already been updated in the previous step
        }
    }

    // REQUIRES: anchorPoint.x > 0 && anchorPoint.y > 0
    // MODIFIES: this
    // EFFECTS: rotates the block clockwise around anchorPoint
    public void rotateRight() {
        if (rotationState + 1 > 3) {
            setRotationState(0);
            setOrientation(0);
        } else {
            setRotationState(rotationState + 1);
            setOrientation(rotationState); // since rotationState has already been updated in the previous step
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
        System.arraycopy(this.coordStates[i], 0, this.orientation, 0, 4);
    }

    public int getRotationState() {
        return rotationState;
    }

    public void setRotationState(int rotationState) {
        this.rotationState = rotationState;
    }
}
