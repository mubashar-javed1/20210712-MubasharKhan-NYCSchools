package com.example.m20210712_mubasharkhan_nycschools.repository

import com.example.m20210712_mubasharkhan_nycschools.network.ApiCall

class RepositoryImp(private val apiCall: ApiCall) : Repository {
    override suspend fun loadAllSchools() = apiCall.loadAllSchools()
}