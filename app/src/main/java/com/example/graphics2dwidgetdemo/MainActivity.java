package com.example.graphics2dwidgetdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    TextView tvOutput;
    GraphicView graphicV;

    int lastDownClickX;
    int lastDownClickY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOutput = findViewById(R.id.tvOutput);
        graphicV = findViewById(R.id.graphicView1);
        graphicV.setOnTouchListener(this);


    }

    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        int x = (int) event.getX();
        int y = (int) event.getY();



        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                tvOutput.setText("DOWN: " + x + ", " + y);
                lastDownClickX = x;
                lastDownClickY = y;
                Log.d("Activity.onTouch", "DOWN: x = " + x + ", y = " + y);
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("Activity.onTouch", "MOVE: x = " + x + ", y = " + y);
                break;
            case MotionEvent.ACTION_UP:
                graphicV.drawRandomShape((Canvas)(v), lastDownClickX, lastDownClickY, x, y);
            case MotionEvent.ACTION_CANCEL:
                Log.d("Activity.onTouch", "UP: x = " + x + ", y = " + y);
                String txt = tvOutput.getText().toString();
                tvOutput.setText(txt + "  UP: " + x + ", " + y);
                break;
        }
        return true;
    }
}