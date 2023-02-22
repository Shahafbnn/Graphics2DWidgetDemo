package com.example.graphics2dwidgetdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class GraphicView extends View
{
    private Paint   fillPaint, strokePaint;
    private Path    mPath;
    Bitmap bmp;

    public GraphicView(Context context)
    {
        super(context);
        init(context);
    }

    public GraphicView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(context);
    }

    public GraphicView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context)
    {
        // for efficiency reasons, we should perform *all* the new
        // operations in the constructor
        // rather than over and over again in OnDraw
        fillPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        fillPaint.setStyle(Paint.Style.FILL);

        strokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        strokePaint.setStyle(Paint.Style.STROKE);

        mPath = new Path();

        // Create bitmaps from resources
        bmp = BitmapFactory.decodeResource(getResources(),
                R.drawable.dog);
    }

    // update Paint Object for filled shapes (FILL style)
    private void setPaintFill(Paint _paint, int color)
    {
        // _paint.setStyle(Paint.Style.FILL);
        _paint.setColor(color);
    }

    // update Paint Object for stroked shapes (STROKE style)
    private void setPaintStroke(Paint _paint, int color, int width)
    {
        // _paint.setStyle(Paint.Style.STROKE);\
        _paint.setColor(color);
        _paint.setStrokeWidth(width);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        int backColor = Color.BLUE;
        int lineColor = Color.YELLOW;
        int fillColor = Color.CYAN;
        int vh, vw;
        float r = 40;

        vh = this.getHeight();  // unfortunately these can only be set here, not in init()
        vw = this.getWidth();
        Log.d("2DGraphics", "vw = " + vw);
        Log.d("2DGraphics", "vh = " + vh);

        // Clear Screen
        fillPaint.setColor(backColor);
        canvas.drawPaint(fillPaint);

        // Straight line using Draw
        setPaintStroke(strokePaint, lineColor, 1);
        canvas.drawLine(0, 50, vw, 50, strokePaint);

        // Straight line using PATH - rline (Relative distance)
        setPaintStroke(strokePaint, lineColor, 2);
        mPath.reset();
        mPath.moveTo(0, 75);
        mPath.rLineTo(vw, 0); // relative distance
        canvas.drawPath(mPath, strokePaint);

        // Straight line using PATH - line (2 points)
        setPaintStroke(strokePaint, lineColor, 3);
        mPath.reset();
        mPath.moveTo(0, 100);
        mPath.lineTo(vw, 100);
        canvas.drawPath(mPath, strokePaint);

        /*** filled & stroked circle using draw ***/
        setPaintFill(fillPaint, fillColor);
        canvas.drawCircle(200, 250, r, fillPaint);
        setPaintStroke(strokePaint, lineColor, 5);
        canvas.drawCircle(200, 250, r, strokePaint);


        /*** filled & stroked rectangle using draw ***/
        setPaintFill(fillPaint, fillColor);
        canvas.drawRect(10, 300, 90, 340, fillPaint);
        setPaintStroke(strokePaint, lineColor, 5);
        canvas.drawRect(10, 300, 90, 340, strokePaint);

        /*** filled & stroked triangle (path - relative) ***/
        mPath.reset();
        int base = 50, h = 70;
        mPath.moveTo(10, 450);
        mPath.rLineTo(base, 0);
        mPath.rLineTo(-base/2, -h);
        mPath.close();
        setPaintFill(fillPaint, fillColor);
        canvas.drawPath(mPath, fillPaint);
        setPaintStroke(strokePaint, lineColor, 5);
        canvas.drawPath(mPath, strokePaint);

        /*** filled & stroked triangle (3 points) ***/
        mPath.reset();
        mPath.moveTo(200, 450);
        mPath.lineTo(200, 500);
        mPath.lineTo(250, 500);
        mPath.close();
        setPaintFill(fillPaint, fillColor);
        canvas.drawPath(mPath, fillPaint);
        setPaintStroke(strokePaint, lineColor, 5);
        canvas.drawPath(mPath, strokePaint);

        // Bitmap (dilbert)
        canvas.drawBitmap(bmp, 300, 130, strokePaint);

        // Bitmap scaled by 2
        int h1, w1;
        h1 = bmp.getHeight();
        w1 = bmp.getWidth();
        int x1 = 300, y1 = 300;
        Rect r1 = new Rect(x1, y1, x1 + w1 / 2, y1 + h1 / 2);
        canvas.drawBitmap(bmp, null, r1, strokePaint);

    }
}
