package com.example.m20210712_mubasharkhan_nycschools;

import android.app.Application;

import com.example.m20210712_mubasharkhan_nycschools.di.component.AppComponent;
import com.example.m20210712_mubasharkhan_nycschools.di.component.DaggerAppComponent;
import com.example.m20210712_mubasharkhan_nycschools.di.module.RetrofitModule;

public class NYCSchoolApplication extends Application {
    AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder().retrofitModule(new RetrofitModule(this)).build();
    }

    public AppComponent getComponent() {
        return component;
    }
}
