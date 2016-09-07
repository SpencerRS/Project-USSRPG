package com.spizzyrichlife.ussrpg_v01;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by SpizzyRich on 9/1/16.
 */
public class MyApplication extends Application{
// This is where stetho inspection lives.
    @Override
    public void onCreate(){
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }

}
