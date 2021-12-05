package com.example.marvel.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvel.R
import com.example.marvel.ui.base.BaseAdapter

@BindingAdapter(value = ["app:imgUrl"])
fun setImageUrl(view: ImageView, url: String?) {
    url?.let {
        Glide.with(view.context)
            .load(url)
            .placeholder(R.drawable.ic_marvel_svgrepo_com)
            .error(R.drawable.ic_error)
            .into(view)
    }
}

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) =
    (view.adapter as BaseAdapter<T>?)?.setItems(items ?: emptyList())