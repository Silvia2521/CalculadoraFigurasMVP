package com.example.triangulo4a.Modelo

import com.example.triangulo4a.Contratos.ContratoHexagono
import kotlin.math.sqrt

class HexagonoModelo : ContratoHexagono.Modelo {

    override fun area(lado: Float): Float {
        // sqrt(3) es 1.73205
        return (3 * sqrt(3.0) / 2.0 * lado.toDouble() * lado.toDouble()).toFloat()
    }

    override fun perimetro(lado: Float): Float {
        return 6 * lado
    }




    override fun valida(lado: Float): Boolean {
        return lado > 0
    }
}