package com.example.m20210712_mubasharkhan_nycschools.repository;

import com.example.m20210712_mubasharkhan_nycschools.model.School;
import com.example.m20210712_mubasharkhan_nycschools.network.ApiCall;
import com.example.m20210712_mubasharkhan_nycschools.network.ApiResponse;

import java.util.List;

public class RepositoryImp implements Repository {
    private final ApiCall apiCall;

    public RepositoryImp(ApiCall apiCall) {
        this.apiCall = apiCall;
    }

    @Override
    public ApiResponse<List<School>> loadAllSchools() {
        return apiCall.loadAllSchools();
    }
}
