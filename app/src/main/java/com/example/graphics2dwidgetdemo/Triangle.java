package com.example.graphics2dwidgetdemo;

import android.graphics.Canvas;
import android.graphics.Path;

public class Triangle extends ClosedShape{
    private int x0;
    private int x1;
    private int x2;

    private int y0;
    private int y1;
    private int y2;

    private Path mPath;

    public Triangle(int lineWidth, int lineColor, int fillColor, int x0, int y0, int x1, int y1, int x2, int y2) {
        super(lineWidth, lineColor, fillColor);
        this.x0 = x0;
        this.x1 = x1;
        this.x2 = x2;
        this.y0 = y0;
        this.y1 = y1;
        this.y2 = y2;
        this.mPath = new Path();
        updatePath();
    }

    private void updatePath(){
        mPath.reset();
        mPath.moveTo(x0, y0);
        mPath.lineTo(x1, y1);
        mPath.lineTo(x2, y2);
        mPath.close();
    }

    public int getX0() {
        return x0;
    }

    public void setX0(int x0) {
        this.x0 = x0;
        updatePath();
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
        updatePath();
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
        updatePath();
    }

    public int getY0() {
        return y0;
    }

    public void setY0(int y0) {
        this.y0 = y0;
        updatePath();
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
        updatePath();
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
        updatePath();
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "x0=" + x0 +
                ", x1=" + x1 +
                ", x2=" + x2 +
                ", y0=" + y0 +
                ", y1=" + y1 +
                ", y2=" + y2 +
                '}';
    }

    public void draw(Canvas canvas){
        canvas.drawPath(mPath, fillPaint);
        canvas.drawPath(mPath, strokePaint);
    }
}
