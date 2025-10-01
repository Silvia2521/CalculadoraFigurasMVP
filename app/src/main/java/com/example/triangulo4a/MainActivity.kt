package com.example.triangulo4a

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.sqrt

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
        //listener del boton para calcular el perimetro
        btnPerimetro.setOnClickListener{
            val l1=txtl1.text.toString().toFloat()
            val l2=txtl2.text.toString().toFloat()
            val l3=txtl3.text.toString().toFloat()
            txvRes.text=txvRes.text.toString()+"\n El perimetro es : ${l1+l2+l3}"
        }
        //listener del boton para definir el tipo de triangulo
        btnTipo.setOnClickListener {
            val l1=txtl1.text.toString().toFloat()
            val l2=txtl2.text.toString().toFloat()
            val l3=txtl3.text.toString().toFloat()
            if(l1==l2 && l2==l3 )
                txvRes.text=txvRes.text.toString()+"\n El Tipo de trianfulo es Equilatero"
            else if(l1!=l2 && l2!=l3 && l1!=l3)
                txvRes.text=txvRes.text.toString()+"\n El Tipo de trianfulo es escaleno"
            else
                txvRes.text=txvRes.text.toString()+"\n El Tipo de trianfulo es isoceles"
        }
        //listener del boton para calcular el area llamando a una funcion
        btnArea.setOnClickListener {
            val l1=txtl1.text.toString().toFloat()
            val l2=txtl2.text.toString().toFloat()
            val l3=txtl3.text.toString().toFloat()
            txvRes.text=txvRes.text.toString()+"\n El Area del triangulo es ${area(l1,l2,l3)}"
        }
    }

    //funcion para calcular el area llamandola desde el lestener
    fun area(l1: Float, l2: Float, l3: Float): String{
        val s=(l1+l2+l3)/2
        return sqrt(s*(s-l1)*(s-l2)*(s-l3)).toString()
    }
}