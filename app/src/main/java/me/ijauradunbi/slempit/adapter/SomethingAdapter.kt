package me.ijauradunbi.slempit.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.ijauradunbi.slempit.R

/**
 * Created on 19/08/2016.
 */
open class SomethingAdapter(internal var contents: List<Any>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        when (position) {
            0 -> return TYPE_HEADER
            else -> return TYPE_CELL
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        when (getItemViewType(position)) {
            TYPE_CELL -> {}
            TYPE_HEADER -> {}
        }
    }

    override fun getItemCount(): Int {
        return contents.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
        var view: View?
        when (viewType) {
            TYPE_HEADER -> {
                view = LayoutInflater.from(parent!!.context).inflate(R.layout.list_item_card_big, parent, false)
                return object: RecyclerView.ViewHolder(view!!) {}
            }

            TYPE_CELL -> {
                view = LayoutInflater.from(parent!!.context).inflate(R.layout.list_item_card_small, parent, false)
                return object: RecyclerView.ViewHolder(view!!) {}
            }
        }
        return null
    }

    companion object {
        internal val TYPE_HEADER = 0
        internal val TYPE_CELL = 1
    }
}