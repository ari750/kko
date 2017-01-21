package com.hanbit.kko.util;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by hb2012 on 2017-01-14.
 */

public class BackPressCloseHandler {

    private long backKeyPressedTime =0;
    private Toast toast;

    private Activity activity;

    public BackPressCloseHandler(Activity context){this.activity=context;}

    public void onBackPressed(){
        if(System.currentTimeMillis()> backKeyPressedTime + 2000){
            backKeyPressedTime = System.currentTimeMillis();
            showGuide();
            return;
        }
        if(System.currentTimeMillis() > backKeyPressedTime + 2000){
            activity.finish();
            showGuide();
            return;
        }

    }

    public void showGuide(){
        //toast = ;


    }

}
