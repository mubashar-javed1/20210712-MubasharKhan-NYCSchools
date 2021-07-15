package com.example.m20210712_mubasharkhan_nycschools.viewmodel

import androidx.lifecycle.*
import com.example.m20210712_mubasharkhan_nycschools.model.School
import com.example.m20210712_mubasharkhan_nycschools.network.ApiResponse
import com.example.m20210712_mubasharkhan_nycschools.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    /*Share Data between Two fragments*/
    private val mutableSelectedSchool = MutableLiveData<School>()
    val selectedSchool: LiveData<School> get() = mutableSelectedSchool
    fun setSchool(school: School) {
        mutableSelectedSchool.value = school
    }

    /*Loading School List for main Fragment*/
    private val mutableSchoolList = MutableLiveData<ApiResponse<List<School>>>()
    private val schoolList : LiveData<ApiResponse<List<School>>> get() = mutableSchoolList

    fun getAllSchools() = schoolList
    fun loadSchoolData() = load()

    private fun load() {
        viewModelScope.launch {
            mutableSchoolList.value = ApiResponse.loading()
            try {
                mutableSchoolList.value = ApiResponse.success(repository.loadAllSchools())
            } catch (e: Exception) {
                mutableSchoolList.value = ApiResponse.error(e.message ?: "Error")
            }
        }
    }

    /*Loading SAT Score for detail Fragment*/
    fun getSatScore(dbn: String) = liveData(Dispatchers.IO) {
        try {
            emit(ApiResponse.success(repository.loadSatScore(dbn)))
        } catch (e: Exception) {
            emit(ApiResponse.error(e.message ?: "Error"))
        }
    }
}