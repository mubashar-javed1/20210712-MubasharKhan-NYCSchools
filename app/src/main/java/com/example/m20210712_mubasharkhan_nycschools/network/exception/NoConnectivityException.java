package com.example.m20210712_mubasharkhan_nycschools.network.exception;

import androidx.annotation.Nullable;

import java.io.IOException;

public class NoConnectivityException extends IOException {
    @Nullable
    @Override
    public String getMessage() {
        return "No Internet Connection";
    }
}
