package com.example.triangulo4a.Presentador

import com.example.triangulo4a.Contratos.ContratoHexagono
import com.example.triangulo4a.Modelo.HexagonoModelo

class HexagonoPresenter(private val vista: ContratoHexagono.Vista) : ContratoHexagono.Presentador {
    private val modelo: ContratoHexagono.Modelo = HexagonoModelo()

    override fun area(lado: Float) {
        if (modelo.valida(lado)) {
            val a = modelo.area(lado)
            vista.showArea(a)
        } else {
            vista.showError("El lad debe ser mayor que cero")
        }
    }

    override fun perimetro(lado: Float) {
        if (modelo.valida(lado)) {
            val p = modelo.perimetro(lado)
            vista.showPerimetro(p)
        } else {
            vista.showError("El lado debe ser mayor que cer")
        }
    }
}