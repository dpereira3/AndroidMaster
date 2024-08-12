package com.example.androidmaster.superheroapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmaster.R

class SuperheroApapter(var superheroListt:List<SuperHeroItemResponse> = emptyList()) : RecyclerView.Adapter<SuperheroViewHolder>() {

    fun updateList(superheroListt: List<SuperHeroItemResponse>){
        this.superheroListt = superheroListt
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        return SuperheroViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return superheroListt.size
    }

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        val item = superheroListt[position]
        holder.bind(item)
    }

}