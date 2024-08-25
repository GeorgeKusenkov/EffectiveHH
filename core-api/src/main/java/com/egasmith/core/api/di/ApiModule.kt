package com.egasmith.core.api.di

import android.content.Context
import com.egasmith.core.api.Api
import com.egasmith.core.api.ApiProvider
import com.egasmith.core.api.utils.AssetJsonReader
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideAssetJsonReader(@ApplicationContext context: Context): AssetJsonReader {
        return AssetJsonReader(context)
    }

    @Provides
    @Singleton
    fun provideApi(jsonReader: AssetJsonReader): Api {
        return ApiProvider(jsonReader).provideApi()
    }
}