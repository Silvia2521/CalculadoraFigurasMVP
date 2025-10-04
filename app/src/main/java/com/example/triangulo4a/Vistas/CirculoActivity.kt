package com.example.triangulo4a.Vistas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.triangulo4a.Contratos.ContratoCirculo
import com.example.triangulo4a.Presentador.CirculoPresenter
import com.example.triangulo4a.R

class CirculoActivity : AppCompatActivity(), ContratoCirculo.Vista {

    private lateinit var txvResultado: TextView
    private lateinit var presentador: ContratoCirculo.Presentador
    private lateinit var edtRadio: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_circulo)


        edtRadio = findViewById(R.id.edtRadio)
        val btnArea: Button = findViewById(R.id.btnAreaCirculo)
        val btnPerimetro: Button = findViewById(R.id.btnPerimetroCirculo)
        txvResultado = findViewById(R.id.txvResCirculo)

        presentador = CirculoPresenter(this)

        btnArea.setOnClickListener {
            try {
                val radio = edtRadio.text.toString().toFloat()
                presentador.area(radio)
            } catch (e: NumberFormatException) {
                showError("Introduce un valor numerico vlido para el radio")
            }
        }

        btnPerimetro.setOnClickListener {
            try {
                val radio = edtRadio.text.toString().toFloat()
                presentador.perimetro(radio)
            } catch (e: NumberFormatException) {
                showError("Introduce un valor numerico valido para el radio")
            }
        }
    }

    override fun showArea(area: Float) {
        txvResultado.text = "El Area es: ${"%.2f".format(area)}"
    }

    override fun showPerimetro(perimetro: Float) {

        txvResultado.text = "El Perimetro es: ${"%.2f".format(perimetro)}"
    }

    override fun showError(msg: String) {
        txvResultado.text = "ERROR: $msg"
    }
}