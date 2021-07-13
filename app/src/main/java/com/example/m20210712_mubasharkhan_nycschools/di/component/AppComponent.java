package com.example.m20210712_mubasharkhan_nycschools.di.component;

import com.example.m20210712_mubasharkhan_nycschools.di.module.MainActivityModule;

import dagger.Component;

@Component(modules = {
        MainActivityModule.class
})
public interface AppComponent {
}
