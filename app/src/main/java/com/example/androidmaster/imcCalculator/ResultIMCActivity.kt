package com.example.androidmaster.imcCalculator

import java.text.DecimalFormat
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidmaster.R
import com.example.androidmaster.imcCalculator.ImcCalculatorActivity.Companion.IMC_KEY

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var tvResult:TextView
    private lateinit var tvIMC:TextView
    private lateinit var tvDescription:TextView
    private lateinit var btnReCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_imcactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val result = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        initComponent()
        initListener()
        initUI(result)
    }

    private fun initListener() {
        btnReCalcular.setOnClickListener{
            onBackPressed()
        }
    }

    private fun initUI(result: Double) {
        //val df = DecimalFormat("#.##")
        //val final = df.format(result).toDouble()
        tvIMC.text = result.toString().substring(0,5) //Muestra hasta 2 decimales

        when(result){
            in 0.00..18.50 -> { //Bajo peso
                tvResult.text = getString(R.string.title_bajo_peso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_bajo))
                tvDescription.text = getString(R.string.description_bajo_peso)
            }
            in 18.51..24.99 -> { //Peso normal
                    tvResult.text = getString(R.string.title_peso_normal)
                    tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_normal))
                    tvDescription.text = getString(R.string.description_peso_normal)
            }
            in 25.00..29.99 -> { //Sobrepeso
                    tvResult.text = getString(R.string.title_sobrepeso)
                    tvResult.setTextColor(ContextCompat.getColor(this, R.color.sobrepeso))
                    tvDescription.text = getString(R.string.description_sobrepeso)
            }
            in 30.00..99.99 -> { //Obesidad
                    tvResult.text = getString(R.string.title_obesidad)
                    tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
                    tvDescription.text = getString(R.string.description_obesidad)
            }
            else -> { //Error
                tvIMC.text = getString(R.string.error)
                    tvResult.text = getString(R.string.error)
                    tvDescription.text = getString(R.string.error)
            }
        }
    }

    private fun initComponent(){
        tvResult = findViewById(R.id.tvResult)
        tvIMC = findViewById(R.id.tvIMC)
        tvDescription = findViewById(R.id.tvDescription)
        btnReCalcular = findViewById(R.id.btnReCalculate)
    }
}