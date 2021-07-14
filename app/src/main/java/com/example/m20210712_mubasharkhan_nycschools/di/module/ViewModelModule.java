package com.example.m20210712_mubasharkhan_nycschools.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.m20210712_mubasharkhan_nycschools.di.scope.ViewModelKey;
import com.example.m20210712_mubasharkhan_nycschools.viewmodel.MainViewModel;
import com.example.m20210712_mubasharkhan_nycschools.viewmodel.ViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory viewModelFactory);
    //You are able to declare ViewModelProvider.Factory dependency in another module. For example in ApplicationModule.

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel userViewModel(MainViewModel userViewModel);
}
