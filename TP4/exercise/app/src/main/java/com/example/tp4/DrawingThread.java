package com.example.tp4;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class DrawingThread extends Thread {
    private SurfaceHolder mySurfaceHolder;
    private DrawingView myDrawingView;
    private boolean myBoolean;

    public DrawingThread (SurfaceHolder mySurfaceHolder, DrawingView myDrawingView, boolean myBoolean) {
        this.mySurfaceHolder = mySurfaceHolder;
        this.myDrawingView = myDrawingView;
        this.myBoolean = myBoolean;

    }

    @Override
    public void run() {
        Canvas c;
        while (myBoolean) {
            c = null;
            try {
                c = mySurfaceHolder.lockCanvas(null);
                synchronized (mySurfaceHolder) {
                    int x = myDrawingView.getWidth() / 2;
                    int y = myDrawingView.getHeight() / 2;
                    int radius = y / 2;
                    Paint paint = new Paint();
                    paint.setColor(Color.parseColor("#ffffff"));
                    c.drawCircle(x, y, radius, paint);
                    myDrawingView.postInvalidate();
                }

            } finally {
                if (c != null) {
                    mySurfaceHolder.unlockCanvasAndPost(c);
                }
            }
        }
    }

    public SurfaceHolder getMySurfaceHolder() {
        return mySurfaceHolder;
    }

    public void setMySurfaceHolder(SurfaceHolder mySurfaceHolder) {
        this.mySurfaceHolder = mySurfaceHolder;
    }

    public DrawingView getMyDrawingView() {
        return myDrawingView;
    }

    public void setMyDrawingView(DrawingView myDrawingView) {
        this.myDrawingView = myDrawingView;
    }

    public boolean isMyBoolean() {
        return myBoolean;
    }

    public void setMyBoolean(boolean myBoolean) {
        this.myBoolean = myBoolean;
    }
}
