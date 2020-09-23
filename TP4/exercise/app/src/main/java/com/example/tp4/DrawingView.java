package com.example.tp4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.R)
public class DrawingView extends SurfaceView implements SurfaceHolder.Callback {

    public DrawingView(Context context, AttributeSet attr) {
        super(context, attr);
        getHolder().addCallback((SurfaceHolder.Callback) this);
    }


    @Override
    public void surfaceCreated (SurfaceHolder holder) {
        DrawingThread thread = new DrawingThread(holder, this, true
        );
        thread.start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
        this.invalidate();

    }

    public void surfaceDestroyed (SurfaceHolder holder) {

    }
    public void onDraw(Canvas canvas) {
        int x = getWidth() / 4;
        int y = getHeight() / 4;
        int radius = y / 4;
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawCircle(x, y, radius, paint);

    }
}
