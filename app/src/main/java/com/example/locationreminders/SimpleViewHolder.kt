package com.example.locationreminders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SimpleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    constructor(parent: ViewGroup) : this (
        LayoutInflater
            .from(parent.context)
            .inflate(R.layout.simple_item, parent, false)
    )
}