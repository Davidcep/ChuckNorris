package com.example.chucknorris.View.Adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.layout_facts.view.*

class   FactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val img = itemView.ivImg
    val fact = itemView.tvFact
}