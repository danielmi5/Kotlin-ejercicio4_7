import kotlin.math.cos

class Cuenta(val numCuenta: String, var saldo: Double = 0.0) {



    fun realizarAbono(abono: Double): Boolean{
        saldo+=abono
        return true
    }

    fun realizarPago(coste: Double): Boolean{
        saldo-= coste
        return true

    }

    override fun toString(): String {
        return "Cuenta(numCuenta='$numCuenta', saldo=$saldo)"
    }
}