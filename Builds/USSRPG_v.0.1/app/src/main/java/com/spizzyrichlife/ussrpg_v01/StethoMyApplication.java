package com.spizzyrichlife.ussrpg_v01;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by SpizzyRich on 9/6/16.
 */
//This is where stetho gets its rules from.
public class StethoMyApplication extends Application {
    @Override
    public void onCreate() {
// Create an InitializerBuilder
        Stetho.InitializerBuilder initializerBuilder =
                Stetho.newInitializerBuilder(this);

// Enable Chrome DevTools
        initializerBuilder.enableWebKitInspector(
                Stetho.defaultInspectorModulesProvider(this)
        );

//// Enable command line interface
//        initializerBuilder.enableDumpapp(
//                Stetho.defaultDumperPluginsProvider(this)
//        );

// Use the InitializerBuilder to generate an Initializer
        Stetho.Initializer initializer = initializerBuilder.build();

// Initialize Stetho with the Initializer
        Stetho.initialize(initializer);
        super.onCreate();
    }
}
