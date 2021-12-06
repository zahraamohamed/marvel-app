package com.example.marvel.util

import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvel.R
import com.example.marvel.data.remote.State
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



@BindingAdapter(value = ["app:showWhenLoading"])
fun <T> showWhenLoading(view: View, status: State<T>?) {
    view.isVisible = (status is State.Loading)
}

@BindingAdapter(value = ["app:showWhenError"])
fun <T> showWhenError(view: View, status: State<T>?) {
    view.isVisible = (status is State.Error)
}

@BindingAdapter(value = ["app:showWhenSuccess"])
fun <T> showWhenSuccess(view: View, status: State<T>?) {
    view.isVisible = (status is State.Success)
}