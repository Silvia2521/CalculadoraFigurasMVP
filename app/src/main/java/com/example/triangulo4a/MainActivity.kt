package com.example.triangulo4a

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //inicializamos elemento a utilizar
        val txtl1: EditText=findViewById<EditText>(R.id.edtL1)
        val txtl2: EditText=findViewById<EditText>(R.id.edtL2)
        val txtl3: EditText=findViewById<EditText>(R.id.edtL3)
        val btnArea: Button=findViewById<Button>(R.id.btnArea)
        val btnPerimetro: Button=findViewById<Button>(R.id.btnPerimetro)
        val btnTipo: Button=findViewById<Button>(R.id.btnTipo)
        val txvRes: TextView=findViewById<TextView>(R.id.txvRes)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnPerimetro.setOnClickListener{
            val l1=txtl1.text.toString().toFloat()
            val l2=txtl2.text.toString().toFloat()
            val l3=txtl3.text.toString().toFloat()
            txvRes.text=txvRes.text.toString()+"\n El perimetro es : ${l1+l2+l3}"
        }
    }
}