package com.example.m20210712_mubasharkhan_nycschools.di.component;

import com.example.m20210712_mubasharkhan_nycschools.di.module.MainActivityModule;
import com.example.m20210712_mubasharkhan_nycschools.di.module.RetrofitModule;
import com.example.m20210712_mubasharkhan_nycschools.di.module.SchoolModule;
import com.example.m20210712_mubasharkhan_nycschools.di.module.ViewModelModule;
import com.example.m20210712_mubasharkhan_nycschools.di.subcomponent.MainActivitySubComponent;

import javax.inject.Singleton;

import dagger.Component;
@Singleton
@Component(modules = {
        MainActivityModule.class,
        RetrofitModule.class,
        SchoolModule.class,
        ViewModelModule.class
})
public interface AppComponent {
    MainActivitySubComponent.Factory mainActivityComponent();
}
