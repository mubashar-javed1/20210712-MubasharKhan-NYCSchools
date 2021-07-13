package com.example.m20210712_mubasharkhan_nycschools.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.m20210712_mubasharkhan_nycschools.NYCSchoolApplication;
import com.example.m20210712_mubasharkhan_nycschools.R;
import com.example.m20210712_mubasharkhan_nycschools.di.subcomponent.MainActivitySubComponent;

public class MainActivity extends AppCompatActivity {
    private MainActivitySubComponent component;

    public MainActivitySubComponent getComponent() {
        return component;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        component = ((NYCSchoolApplication)getApplication()).getComponent().mainActivityComponent().create();
        component.inject(this);
    }
}