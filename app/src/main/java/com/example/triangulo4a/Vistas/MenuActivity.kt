package com.example.triangulo4a.Vistas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.triangulo4a.R

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val btnTriangulo: Button = findViewById(R.id.btnTriangulo)
        val btnRectangulo: Button = findViewById(R.id.btnRectangulo)
        val btnCirculo: Button = findViewById(R.id.btnCirculo)
        val btnHexagono: Button = findViewById(R.id.btnHexagono)


        btnTriangulo.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        btnRectangulo.setOnClickListener {
            startActivity(Intent(this, RectanguloActivity::class.java))
        }


        btnCirculo.setOnClickListener {
            startActivity(Intent(this, CirculoActivity::class.java))
        }


        btnHexagono.setOnClickListener {
            startActivity(Intent(this, HexagonoActivity::class.java))
        }
    }
}