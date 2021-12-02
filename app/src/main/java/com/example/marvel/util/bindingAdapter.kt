package com.example.marvel.util

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvel.R
import com.example.marvel.data.remote.response.Thumbnail
import com.example.marvel.ui.base.BaseAdapter

@BindingAdapter(value = ["app:imgUrl"])
fun setImageUrl(view: ImageView, url: Thumbnail?) {
    url?.let {
        Glide.with(view.context)
            .load("${url.path}.${url.extension}")
            .placeholder(R.drawable.ic_home)
            .error(R.drawable.ic_launcher_background)
            .into(view)
    }
}

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) =
    (view.adapter as BaseAdapter<T>?)?.setItems(items ?: emptyList())