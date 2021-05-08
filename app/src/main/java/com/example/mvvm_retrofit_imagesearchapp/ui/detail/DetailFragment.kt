package com.example.mvvm_retrofit_imagesearchapp.ui.detail

import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.mvvm_retrofit_imagesearchapp.R
import com.example.mvvm_retrofit_imagesearchapp.databinding.FragmentDetailBinding

class DetailFragment : Fragment(R.layout.fragment_detail){

    private val args by navArgs<DetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentDetailBinding.bind(view)
        binding.apply {
            val photo = args.photo

            Glide.with(this@DetailFragment)
                .load(photo.urls.full)
                .error(R.drawable.ic_error)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(e: GlideException?,model: Any?,target: Target<Drawable>?,isFirstResource: Boolean): Boolean {
                        progressBar.isVisible = false
                        return false
                    }

                    override fun onResourceReady(resource: Drawable?,model: Any?,target: Target<Drawable>?,dataSource: DataSource?,isFirstResource: Boolean): Boolean {
                        progressBar.isVisible = false
                        textviewDesc.isVisible = photo.description != null
                        textviewCreator.isVisible = true
                        return false
                    }

                })
                .into(imageView)

            textviewDesc.text = photo.description

            val uri = Uri.parse(photo.user.attributionUrl)
            val intent = Intent(Intent.ACTION_VIEW, uri)

            textviewCreator.apply {
                text = "Photo by ${photo.user.name} on Unsplash"
                setOnClickListener {
                    context.startActivity(intent)
                }
                paint.isUnderlineText = true
            }
        }
    }
}