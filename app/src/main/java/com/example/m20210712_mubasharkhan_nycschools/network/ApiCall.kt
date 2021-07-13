package com.example.m20210712_mubasharkhan_nycschools.network

import com.example.m20210712_mubasharkhan_nycschools.model.School
import retrofit2.http.GET

interface ApiCall {
    @GET(ApiConfig.GET_SCHOOL_LIST)
    fun loadAllSchools() : ApiResponse<List<School>>
}