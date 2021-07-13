package com.example.m20210712_mubasharkhan_nycschools;

import android.app.Application;

import com.example.m20210712_mubasharkhan_nycschools.di.component.AppComponent;
import com.example.m20210712_mubasharkhan_nycschools.di.component.DaggerAppComponent;

public class NYCSchoolApplication extends Application {
    AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder().build();
    }

    public AppComponent getComponent() {
        return component;
    }
}
