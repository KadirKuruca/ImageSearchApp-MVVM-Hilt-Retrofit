package com.example.mvvm_retrofit_imagesearchapp.ui.gallery

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mvvm_retrofit_imagesearchapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GalleryFragment : Fragment(R.layout.fragment_gallery) {

    private val viewModel by viewModels<GalleryViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.photos.observe(viewLifecycleOwner){
            
        }
    }
}