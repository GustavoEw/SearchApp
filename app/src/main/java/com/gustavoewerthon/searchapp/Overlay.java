package com.gustavoewerthon.searchapp;




import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;


public class Overlay {

    Context context;
    WindowManager windowManager ;

    public Overlay(Context context){
        this.context = context;
        this.windowManager =
                (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
    }
    WindowManager.LayoutParams params = new WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ?
                    WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
            android.graphics.PixelFormat.TRANSLUCENT
    );

    View overlayView = LayoutInflater.from(context).inflate(R.layout.overlay, null);
   public void show(){
       windowManager.addView(overlayView,params);
   }
    int dptoPx(int dp){
        int px =(int) (dp *context.getResources().getDisplayMetrics().density);
        return px;
    }
}
