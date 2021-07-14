package com.example.m20210712_mubasharkhan_nycschools.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.m20210712_mubasharkhan_nycschools.model.School
import com.example.m20210712_mubasharkhan_nycschools.network.ApiResponse
import com.example.m20210712_mubasharkhan_nycschools.repository.Repository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: Repository): ViewModel() {
    private val mutableSelectedSchool = MutableLiveData<School>()
    val selectedSchool: LiveData<School> get() = mutableSelectedSchool

    fun setSchool(school: School) {
        mutableSelectedSchool.value = school
    }

    fun getAllSchools() = liveData(Dispatchers.IO) {
        emit(ApiResponse.loading())
        try {
            emit(ApiResponse.success(repository.loadAllSchools()))
        } catch (e : Exception) {
            emit(ApiResponse.error(e.message ?: "Error"))
        }
    }
}