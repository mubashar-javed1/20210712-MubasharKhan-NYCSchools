package com.example.m20210712_mubasharkhan_nycschools.repository;

import com.example.m20210712_mubasharkhan_nycschools.model.School;
import com.example.m20210712_mubasharkhan_nycschools.network.ApiResponse;

import java.util.List;

public interface Repository {
    ApiResponse<List<School>> loadAllSchools();
}