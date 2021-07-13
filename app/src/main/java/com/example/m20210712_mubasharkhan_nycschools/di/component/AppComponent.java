package com.example.m20210712_mubasharkhan_nycschools.di.component;

import com.example.m20210712_mubasharkhan_nycschools.di.module.MainActivityModule;
import com.example.m20210712_mubasharkhan_nycschools.di.subcomponent.MainActivitySubComponent;

import dagger.Component;

@Component(modules = {
        MainActivityModule.class
})
public interface AppComponent {
    MainActivitySubComponent.Factory mainActivityComponent();
}
