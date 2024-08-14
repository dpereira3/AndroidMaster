package com.example.androidmaster.superheroapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidmaster.R
import com.example.androidmaster.databinding.ActivitySuperHeroListMainBinding
import com.example.androidmaster.superheroapp.DetailSuperheroActivity.Companion.EXTRA_ID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class SuperHeroListMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuperHeroListMainBinding
    private lateinit var retrofit: Retrofit

    private lateinit var adapter: SuperheroApapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySuperHeroListMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        retrofit = getRetrofit()
        initUI()
    }

    private fun initUI(){
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener
        {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        adapter = SuperheroApapter { superheroid -> navigateToDetail(superheroid) }
        binding.rvSuperhero.setHasFixedSize(true)
        binding.rvSuperhero.layoutManager = LinearLayoutManager(this)
        binding.rvSuperhero.adapter = adapter
    }


    private fun searchByName(query: String){
        binding.progressBar.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<SuperHeroDataResponse> = retrofit.create(ApiService::class.java).getSuperHeroes(query)
            if(myResponse.isSuccessful){
                Log.i("Aris", "Funciona")
                val response: SuperHeroDataResponse? = myResponse.body()
                if(response != null){
                    Log.i("Aris", response.toString())
                    runOnUiThread{
                        adapter.updateList(response.superheroes)
                        binding.progressBar.isVisible = false
                    }
                }
            }else{
                Log.i("Aris", "No funciona")
            }
        }

    }//Busqueda de los superheroes a partir del contenido del edittexk

    private fun getRetrofit(): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://superheroapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }

    private fun navigateToDetail(id: String){
        val intent = Intent(this, DetailSuperheroActivity::class.java)
        intent.putExtra(EXTRA_ID, id)
        startActivity(intent)
    }//Para abrir la pantalla de detalle, pasa el id para buscar el superheroe
}