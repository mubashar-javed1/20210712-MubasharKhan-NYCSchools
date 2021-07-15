package com.example.m20210712_mubasharkhan_nycschools.network.exception;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Response;

public class ConnectivityInterceptorImp implements ConnectivityInterceptor {
    private final Context appContext;
    public ConnectivityInterceptorImp(Context context) {
        appContext = context.getApplicationContext();
    }
    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        if (!isOnline()) {
            throw new NoConnectivityException();
        }
        return chain.proceed(chain.request());
    }

    private boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager)appContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Network nw = cm.getActiveNetwork();
            if (nw == null) return false;
            NetworkCapabilities actNw = cm.getNetworkCapabilities(nw);
            return actNw != null &&
                    (actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                            || actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                            || actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
                            || actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH));
        } else {
            NetworkInfo nwInfo = cm.getActiveNetworkInfo();
            return nwInfo != null && nwInfo.isConnected();
        }
    }
}
