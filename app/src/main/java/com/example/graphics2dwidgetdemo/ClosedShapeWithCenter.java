package com.example.graphics2dwidgetdemo;

public class ClosedShapeWithCenter extends ClosedShape{
    protected int centerX;
    protected int centerY;

    public ClosedShapeWithCenter(int lineWidth, int lineColor, int fillColor, int centerX, int centerY) {
        super(lineWidth, lineColor, fillColor);
        this.centerX = centerX;
        this.centerY = centerY;
    }

    public int getCenterX() {
        return centerX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    @Override
    public String toString() {
        return "ClosedShapeWithCenter{" + super.toString() +
                "centerX=" + centerX +
                ", centerY=" + centerY +
                '}';
    }

    @Override
    public int getFillColor() {
        return super.getFillColor();
    }

    @Override
    public void setFillColor(int fillColor) {
        super.setFillColor(fillColor);
    }

}
