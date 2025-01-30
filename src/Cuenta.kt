import kotlin.math.cos

class Cuenta(val numCuenta: String, var saldo: Double = 0.0) {



    fun realizarAbono(abono: Double): Boolean{
        saldo+=abono
        return true
    }

    fun realizarPago(coste: Double): Boolean{
        if (saldo - coste < 0) throw IllegalArgumentException("Saldo insuficiente") else {
            saldo-= coste
            return true
        }
    }






}