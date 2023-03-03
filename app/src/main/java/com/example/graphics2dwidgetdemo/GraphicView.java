package com.example.graphics2dwidgetdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.Random;
public class GraphicView extends View
{

    private ArrayList<Shape> drawShapes;

    public void addShape(Shape s){
        drawShapes.add(s);
    }
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
        drawShapes = new ArrayList<Shape>();
    }



    public void drawRandomShape(int xStart, int yStart, int xEnd, int yEnd){
        Log.v("Shaper", "Grafx x0:" + xStart + "Grafx y0:" + yStart);
        Log.v("Shaper", "Grafx x1:" + xEnd + "Grafx y1:" + yEnd);
        //int r = (int) Math.min(Math.abs(xEnd - xStart)/2 , Math.abs(yEnd - yStart)/2); //radius
        int r = (int) (Math.sqrt((xEnd - xStart)*(xEnd - xStart) + (yEnd - yStart)*(yEnd - yStart)))/2; //diameter
        int Width = xEnd - xStart;
        int Height = yEnd - yStart;
        int xCenter = xStart + Width/2;
        int yCenter = yStart + Height/2;

        Random rand = new Random();
        int randNum = rand.nextInt(4) + 1;
        int randLineWidth = rand.nextInt(9) + 1;
        int randLineColor = Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        int randFillColor = Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));

        if(randNum == 1) this.addShape(new Line(randLineWidth, randLineColor, xStart, yStart, xEnd, yEnd));
        else if(randNum==2) this.addShape(new Rectangle(randLineWidth, randLineColor, randFillColor, xCenter, yCenter, Math.abs(Width), Math.abs(Height)));
        else if(randNum==3) this.addShape(new Circle(randLineWidth, randLineColor, randFillColor, xCenter, yCenter, r ));
        else if(randNum==4) this.addShape(new Triangle(randLineWidth, randLineColor, randFillColor, xStart, yEnd, xEnd, yEnd, xCenter, yStart));
        Log.v("Shaper", "" + drawShapes.get(drawShapes.size()-1));
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            drawShapes.forEach(shape -> {shape.draw(canvas);});
        }
    }
}
