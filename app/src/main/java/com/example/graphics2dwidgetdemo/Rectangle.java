package com.example.graphics2dwidgetdemo;

import android.graphics.Canvas;

public class Rectangle extends ClosedShapeWithCenter{
    private int width;
    private int height;

    public Rectangle(int lineWidth, int lineColor, int fillColor, int centerX, int centerY, int width, int height) {
        super(lineWidth, lineColor, fillColor, centerX, centerY);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle{" + super.toString() +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    public void draw(Canvas canvas){
        canvas.drawRect((int)(centerX - width/2), (int)(centerY - height/2), (int)(centerX + width/2), (int)(centerY + width/2), fillPaint);
        canvas.drawRect((int)(centerX - width/2), (int)(centerY - height/2), (int)(centerX + width/2), (int)(centerY + width/2), strokePaint);

//        int w = this.width / 2, h = this.height / 2;
//        canvas.drawRect(this.centerX - w, this.centerY - h, this.centerX + w, this.centerY + h, this.fillPaint);
//        canvas.drawRect(this.centerX - w, this.centerY - h, this.centerX + w, this.centerY + h, this.strokePaint);
    }
}
