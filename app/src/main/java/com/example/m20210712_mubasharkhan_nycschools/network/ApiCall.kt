package com.example.m20210712_mubasharkhan_nycschools.network

import com.example.m20210712_mubasharkhan_nycschools.model.SatScore
import com.example.m20210712_mubasharkhan_nycschools.model.School
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCall {
    @GET(ApiConfig.GET_SCHOOL_LIST)
    suspend fun loadAllSchools() : List<School>

    @GET(ApiConfig.GET_SAT_SCORE)
    suspend fun loadSatScore(@Query("dbn") dbn : String) : List<SatScore>
}