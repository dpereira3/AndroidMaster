package com.example.androidmaster.superheroapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmaster.R

class SuperheroApapter(
    var superheroListt: List<SuperHeroItemResponse> = emptyList(),
    private val onItemSelected: (String) -> Unit
) : RecyclerView.Adapter<SuperheroViewHolder>() {

    fun updateList(superheroListt: List<SuperHeroItemResponse>) {
        this.superheroListt = superheroListt
        notifyDataSetChanged()
    }//Actualiza la lista de superheroes a mostras

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        return SuperheroViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        )
    }//Pasa los valores a mostrar

    override fun getItemCount(): Int {
        return superheroListt.size
    }//Tamaño de la lista a mostrar

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        val item = superheroListt[position]
        holder.bind(item, onItemSelected)
    }

}