package com.example.m20210712_mubasharkhan_nycschools.repository

import com.example.m20210712_mubasharkhan_nycschools.model.SatScore
import com.example.m20210712_mubasharkhan_nycschools.model.School

interface Repository {
   suspend fun loadAllSchools(): List<School>
   suspend fun loadSatScore(dbn: String): List<SatScore>
}