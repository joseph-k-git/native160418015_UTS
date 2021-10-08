package com.joseph18.ifubaya.adv160418015utsrecipedia.model.util

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.joseph18.ifubaya.adv160418015utsrecipedia.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class Util {
    companion object {
        fun ImageView.loadImage(url:String, progressBar:ProgressBar) {
            Picasso.get()
                .load(url)
                .resize(400, 400)
                .centerCrop()
                .error(R.drawable.ic_baseline_error_24)
                .into(this, object: Callback {
                    override fun onSuccess() {
                        progressBar.visibility = View.GONE
                    }
                    override fun onError(e: Exception) {
                    }
                })
        }
    }
}