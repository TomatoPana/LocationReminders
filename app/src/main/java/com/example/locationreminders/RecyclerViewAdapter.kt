package com.example.locationreminders

import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(
    private val layoutManager: GridLayoutManager
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    enum class ViewType {
        SMALL,
        DETAILED
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ViewType.DETAILED.ordinal -> DetailedViewHolder(parent)
            else -> SimpleViewHolder(parent)
        }
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {}

    override fun getItemCount() = 6

    override fun getItemViewType(position: Int): Int {
        return if (layoutManager.spanCount != 1) ViewType.DETAILED.ordinal
        else ViewType.SMALL.ordinal
    }
}
