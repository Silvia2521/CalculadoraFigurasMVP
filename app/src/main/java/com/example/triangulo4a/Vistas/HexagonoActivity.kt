package com.example.triangulo4a.Vistas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.triangulo4a.Contratos.ContratoHexagono
import com.example.triangulo4a.Presentador.HexagonoPresenter
import com.example.triangulo4a.R
import java.lang.NumberFormatException

class HexagonoActivity : AppCompatActivity(), ContratoHexagono.Vista {

    private lateinit var txvResultado: TextView
    private lateinit var presentador: ContratoHexagono.Presentador
    private lateinit var edtLado: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hexagono)

        edtLado = findViewById(R.id.edtLado)
        val btnArea: Button = findViewById(R.id.btnAreaHexagono)
        val btnPerimetro: Button = findViewById(R.id.btnPerimetroHexagono)
        txvResultado = findViewById(R.id.txvResHexagono)

        presentador = HexagonoPresenter(this)

        btnArea.setOnClickListener {
            try {
                val lado = edtLado.text.toString().toFloat()
                presentador.area(lado)
            } catch (e: NumberFormatException) {
                showError("Introduce un valor numerico valido para el lad")
            }
        }

        btnPerimetro.setOnClickListener {
            try {
                val lado = edtLado.text.toString().toFloat()
                presentador.perimetro(lado)
            } catch (e: NumberFormatException) {
                showError("Introduce un valor numrico vlido para el lado")
            }
        }
    }

    override fun showArea(area: Float) {
        txvResultado.text = "El Area es: ${"%.2f".format(area)}"
    }

    override fun showPerimetro(perimetro: Float) {
        txvResultado.text = "El perimetro es: ${"%.2f".format(perimetro)}"
    }

    override fun showError(msg: String) {
        txvResultado.text = "ERROR: $msg"
    }
}