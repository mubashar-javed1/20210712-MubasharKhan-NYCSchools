package com.example.m20210712_mubasharkhan_nycschools.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.m20210712_mubasharkhan_nycschools.network.ApiResponse
import com.example.m20210712_mubasharkhan_nycschools.repository.Repository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import javax.inject.Inject

class MainViewModel (@Inject private val repository: Repository): ViewModel() {
    fun getUsers() = liveData(Dispatchers.IO) {
        emit(ApiResponse.loading())
        try {
            emit(ApiResponse.success(repository.loadAllSchools()))
        } catch (e : Exception) {
            emit(ApiResponse.error(message = e.message ?: "Error"))
        }
    }
}