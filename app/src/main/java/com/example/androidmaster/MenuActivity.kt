package com.example.androidmaster

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidmaster.firsapp.FirstAppActivity
import com.example.androidmaster.imcCalculator.ImcCalculatorActivity
import com.example.androidmaster.superheroapp.SuperHeroListMainActivity
import com.example.androidmaster.todoapp.TodoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSaludApp = findViewById<AppCompatButton>(R.id.btnSaludApp)

        btnSaludApp.setOnClickListener { navigateToSaludApp() }

        val btnImcApp = findViewById<AppCompatButton>(R.id.btnImcApp)

        btnImcApp.setOnClickListener { navigateToImcApp() }

        val btnTodo = findViewById<AppCompatButton>(R.id.btnTODO)

        btnTodo.setOnClickListener{ navigateToTODOApp() }

        val btnSuperHero = findViewById<AppCompatButton>(R.id.btnSuperHero)

        btnSuperHero.setOnClickListener{ navigateToSuperHeroApp() }

    }

    private fun navigateToSuperHeroApp() {
        val intent = Intent(this, SuperHeroListMainActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToTODOApp() {
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToImcApp() {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaludApp(){
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }
}