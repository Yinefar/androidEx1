package com.cibertec.subsidioex

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    var txtMonto: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        txtMonto = findViewById(R.id.txtMonto)
    }

    fun calcular(view: View) {
        val txtHijos: EditText = findViewById(R.id.txtHijos)
        val txtEstado: EditText = findViewById(R.id.txtEstado)

        val estado = txtEstado.text.toString()
        val hijos = txtHijos.text.toString().toInt()

        var monto = 0.0
        var porHijo = 0.0

        when (estado) {
            "viu" -> monto = 55.0
            "cas" -> monto = 25.0
            "sol" -> monto = 10.0 * hijos
        }

        porHijo = when {
            hijos <= 3 -> 75.0 * hijos
            hijos in 4..6 -> 110.0 * hijos
            else -> 120.0 * hijos
        }

        val montoTotal = monto + porHijo
        txtMonto?.text = "Monto total: %.2f soles".format(montoTotal)
    }
}

