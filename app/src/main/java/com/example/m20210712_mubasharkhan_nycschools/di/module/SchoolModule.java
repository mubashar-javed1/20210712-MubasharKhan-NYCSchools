package com.example.m20210712_mubasharkhan_nycschools.di.module;

import com.example.m20210712_mubasharkhan_nycschools.network.ApiCall;
import com.example.m20210712_mubasharkhan_nycschools.repository.Repository;
import com.example.m20210712_mubasharkhan_nycschools.repository.RepositoryImp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class SchoolModule {
    @Provides
    @Singleton
    ApiCall getApiCallInterface(Retrofit retrofit) {
        return retrofit.create(ApiCall.class);
    }

    @Provides
    @Singleton
    Repository getRepository(ApiCall apiCallInterface) {
        return new RepositoryImp(apiCallInterface);
    }
}
