package com.example.graphics2dwidgetdemo;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Shape {
    protected int lineWidth;
    protected int lineColor;
    protected Paint strokePaint;

    public Shape(int lineWidth, int lineColor){
        this.lineWidth = lineWidth;
        this.lineColor = lineColor;
        strokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        strokePaint.setStyle(Paint.Style.STROKE);
        this.strokePaint.setColor(this.lineColor);
        this.strokePaint.setStrokeWidth(this.lineWidth);
    }

    public int getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(int lineWidth) {
        this.lineWidth = lineWidth;
        this.strokePaint.setStrokeWidth(this.lineWidth);
    }

    public int getLineColor() {
        return lineColor;
    }

    public void setLineColor(int lineColor) {
        this.lineColor = lineColor;
        this.strokePaint.setColor(this.lineColor);

    }

    @Override
    public String toString() {
        return "Shape{" +
                "lineWidth=" + lineWidth +
                ", lineColor=" + lineColor +
                ", strokePaint=" + strokePaint +
                '}';
    }

    public void draw(Canvas canvas){}
}
