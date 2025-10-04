package com.example.triangulo4a.Vistas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.triangulo4a.Contratos.ContratoRectangulo
import com.example.triangulo4a.Presentador.RectanguloPresenter
import com.example.triangulo4a.R

class RectanguloActivity : AppCompatActivity(), ContratoRectangulo.Vista {

    private lateinit var txvResultado: TextView
    private lateinit var presentador: ContratoRectangulo.Presentador
    private lateinit var edtBase: EditText
    private lateinit var edtAltura: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_rectangulo)

        edtBase = findViewById(R.id.edtBase)
        edtAltura = findViewById(R.id.edtAltura)
        val btnArea: Button = findViewById(R.id.btnAreaRectangulo)
        val btnPerimetro: Button = findViewById(R.id.btnPerimetroRectangulo)
        txvResultado = findViewById(R.id.txvResRectangulo)


        presentador = RectanguloPresenter(this)

        btnArea.setOnClickListener {
            try {
                val base = edtBase.text.toString().toFloat()
                val altura = edtAltura.text.toString().toFloat()
                presentador.area(base, altura)
            } catch (e: NumberFormatException) {
                showError("Introduce valores numericos validos.")
            }
        }

        btnPerimetro.setOnClickListener {
            try {
                val base = edtBase.text.toString().toFloat()
                val altura = edtAltura.text.toString().toFloat()
                presentador.perimetro(base, altura)
            } catch (e: NumberFormatException) {
                showError("Introduce valores numericos validos")
            }
        }
    }

    // Métodos de la Interfaz ContratoRectangulo.Vista
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