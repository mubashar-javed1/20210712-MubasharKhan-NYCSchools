package com.example.m20210712_mubasharkhan_nycschools.network;

import java.util.Base64;

public class ApiConfig {
    private ApiConfig() {
    }

    public static final String BASE = "https://data.cityofnewyork.us/";
    public static final String GET_SCHOOL_LIST = BASE.concat("Education/DOE-High-School-Directory-2017/s3k6-pzi2");
    public static final String GET_SAT_DATA = BASE.concat("Education/SAT-Results/f9bf-2cp4");
}
