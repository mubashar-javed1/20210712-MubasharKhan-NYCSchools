package com.example.m20210712_mubasharkhan_nycschools.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.m20210712_mubasharkhan_nycschools.di.scope.MainActivityScope
import com.example.m20210712_mubasharkhan_nycschools.network.ApiResponse
import com.example.m20210712_mubasharkhan_nycschools.repository.Repository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import javax.inject.Inject

@MainActivityScope
class MainViewModel @Inject constructor(private val repository: Repository): ViewModel() {
    fun getAllSchools() = liveData(Dispatchers.IO) {
        emit(ApiResponse.loading())
        try {
            emit(ApiResponse.success(repository.loadAllSchools()))
        } catch (e : Exception) {
            emit(ApiResponse.error(e.message ?: "Error"))
        }
    }
}