package com.drsync.newsapp.di

import android.content.Context
import com.drsync.newsapp.data.NewsRepository
import com.drsync.newsapp.data.local.room.NewsDatabase
import com.drsync.newsapp.data.remote.retrofit.ApiConfig

object Injection {
    fun provideRepository(context: Context): NewsRepository {
        val apiService = ApiConfig.getApiService()
        val database = NewsDatabase.getInstance(context)
        val dao = database.newsDao()
        return NewsRepository.getInstance(apiService, dao)
    }
}