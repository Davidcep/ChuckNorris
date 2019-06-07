package com.example.chucknorris.Adapter

import android.support.v7.appcompat.R
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.chucknorris.Model.Fact
import com.squareup.picasso.Picasso

class FactAdapter(val data: List<Fact>): RecyclerView.Adapter<FactViewHolder>() {

    //Overwrite posts_layout with the PostViewHolder
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): FactViewHolder {
        var itemView = LayoutInflater.from(p0.context).inflate(com.example.chucknorris.R.layout.layout_facts, p0, false)
        return FactViewHolder(itemView)
    }

    //RecyclerView size
    override fun getItemCount(): Int {
        return data.size
    }

    //Get items from ViewHolder to RecyclerView
    override fun onBindViewHolder(p0: FactViewHolder, p1: Int) {
        Picasso.get().load(data[p1].img).into(p0.img);
        p0.fact.text = data[p1].quote
    }
}