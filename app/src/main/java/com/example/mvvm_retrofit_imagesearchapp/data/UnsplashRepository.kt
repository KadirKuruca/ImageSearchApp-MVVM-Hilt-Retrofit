package com.example.mvvm_retrofit_imagesearchapp.data

import com.example.mvvm_retrofit_imagesearchapp.api.UnsplashApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnsplashRepository @Inject constructor(private val unsplashApi: UnsplashApi) {
}