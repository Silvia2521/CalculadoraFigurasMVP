package com.example.triangulo4a.Modelo

import com.example.triangulo4a.Contratos.ContratoCirculo
import kotlin.math.PI

class CirculoModelo : ContratoCirculo.Modelo {
    override fun area(radio: Float): Float {

        return PI.toFloat() * radio * radio
    }

    override fun perimetro(radio: Float): Float {

        return 2 * PI.toFloat() * radio
    }

    override fun valida(radio: Float): Boolean {
        return radio > 0
    }


}