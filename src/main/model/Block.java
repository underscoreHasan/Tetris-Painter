package model;

import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public abstract class Block {

    private Point[][] coordStates;
    private Color color;
    private Point[] orientation;
    private Point anchorPoint;

    public void oneLineDown() {

    }

    public void moveRight() {

    }

    public void moveLeft() {

    }

    public void rotateLeft() {

    }

    public void rotateRight() {

    }

    public void dropHard() {

    }

    public void dropSoft() {

    }

    public Point getAnchorPoint() {
        return anchorPoint;
    }

    public void setAnchorPoint(Point anchorPoint) {
        this.anchorPoint = anchorPoint;
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
    }

    public Point getPoint(int index) {
        return this.orientation[index];
    }

    public void setPoint(int index, int x, int y) {
        this.orientation[index].setLocation(x, y);
    }
}
