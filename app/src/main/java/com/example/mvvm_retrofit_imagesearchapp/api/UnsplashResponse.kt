package com.example.mvvm_retrofit_imagesearchapp.api

import com.example.mvvm_retrofit_imagesearchapp.data.UnsplashPhoto

data class UnsplashResponse(
    val results : List<UnsplashPhoto>
)