package com.example.marvel.ui.home

import android.view.ViewGroup
import com.example.marvel.BR
import com.example.marvel.R
import com.example.marvel.ui.base.BaseAdapter
import com.example.marvel.util.HomeItem

class HomeNestedRecyclerAdapter(
    private var itemsNested: MutableList<HomeItem>,
    private val listener: HomeInteractionListener,
) : BaseAdapter<Any>(itemsNested, listener) {

    override var layoutID = 0

    fun addItem(newItems: HomeItem) {
        itemsNested.apply {
            add(newItems)
            sortBy {
                it.number
            }
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        layoutID = getLayout(viewType)
        return super.onCreateViewHolder(parent, viewType)
    }

    private fun getLayout(viewType: Int): Int =
        when (viewType) {
            TYPE_CHARACTER -> R.layout.items_nested_characteres

            TYPE_CREATORS -> R.layout.items_nested_creators
            TYPE_COMICS -> R.layout.items_nested_comics
            else -> R.layout.items_nested_characteres
        }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        bind(holder as ItemViewHolder, position)
    }

    private fun bind(holder: ItemViewHolder, position: Int) {
        when (val currentItem = itemsNested[position]) {

            is HomeItem.CharacterType -> {
                holder.binding.setVariable(BR.adapter,
                    CharacterAdapter(currentItem.items, listener))

            }
            is HomeItem.CreatorType -> {
                holder.binding.setVariable(BR.adapter,
                    CreatorAdapter(currentItem.items, listener))
            }
            is HomeItem.ComicsType -> {
                holder.binding.setVariable(BR.adapter,
                    ComicsAdapter(currentItem.items, listener))
            }
        }
    }


    override fun getItemViewType(position: Int): Int =
        when (itemsNested[position]) {

            is HomeItem.CharacterType -> TYPE_CHARACTER
            is HomeItem.CreatorType -> TYPE_CREATORS
            is HomeItem.ComicsType -> TYPE_COMICS
        }

    companion object {
        const val TYPE_CHARACTER = 1
        const val TYPE_COMICS = 2
        const val TYPE_CREATORS = 3

    }

}