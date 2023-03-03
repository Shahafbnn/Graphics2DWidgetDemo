package com.example.graphics2dwidgetdemo;

import android.graphics.Paint;

public class ClosedShape extends Shape{
    protected int fillColor;
    protected Paint fillPaint;

    public ClosedShape(int lineWidth, int lineColor, int fillColor) {
        super(lineWidth, lineColor);
        this.fillColor = fillColor;
        this.fillPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        this.fillPaint.setStyle(Paint.Style.FILL);
        this.fillPaint.setColor(fillColor);
    }

    public int getFillColor() {
        return fillColor;
    }

    public void setFillColor(int fillColor) {
        this.fillColor = fillColor;
        this.fillPaint.setColor(fillColor);
    }

    public Paint getFillPaint() {
        return fillPaint;
    }

    public void setFillPaint(Paint fillPaint) {
        this.fillPaint = fillPaint;
    }

    @Override
    public String toString() {
        return "ClosedShape{" + super.toString() +
                "fillColor=" + fillColor +
                ", fillPaint=" + fillPaint +
                '}';
    }

}
