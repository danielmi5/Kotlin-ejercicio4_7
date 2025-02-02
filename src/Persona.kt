import funciones.contar

class Persona(val nombre: String ,val dni: String) {
    val listaCuentasBancarias: Array<Cuenta?> = arrayOfNulls(3)
    init {
        require(listaCuentasBancarias.size in 0..3){"Has superado el número de cuentas permitidas."}
    }

    fun aniadirCuenta(cuenta: Cuenta){
        val lista = listaCuentasBancarias.toList()

            if (lista.contar(null) > 0){
                var cont = 1
                for (i in listaCuentasBancarias.indices){
                    if (listaCuentasBancarias[i] == null && cont == 1){
                        listaCuentasBancarias[i] = cuenta
                        cont++
                    }
                }

            } else throw IndexOutOfBoundsException("Máximo de cuentas superado")
    }

    fun esMorosa(): Boolean{
        //He cambiado que no reciba parámetro ya que considero que no tiene sentido llamar al objeto para recibir como parámetro el mismo objeto

        for (i in this.listaCuentasBancarias){
            if (i!=null && i.saldo < 0) return true
        }
        return false
    }

    init {
        require(dni.matches(Regex("^\\d{8}[A-Z]\$"))) {"DNI incorrecto"}
    }
    fun realizarTransferencia(persona2: Persona, numCuenta1: String, numCuenta2: String, cantidad: Double): Boolean{
        //Igual que en la función esMorosa
        val persona1 = this
        var completado = false
        try {
            for (i in listaCuentasBancarias.indices){
                val cuenta = persona1.listaCuentasBancarias[i]
                if (cuenta?.numCuenta == numCuenta1){
                    if (cuenta.realizarPago(cantidad)) completado = true
                }
            }

            for (i in listaCuentasBancarias.indices){
                val cuenta = persona2.listaCuentasBancarias[i]
                if (cuenta?.numCuenta == numCuenta2){
                    if (cuenta.realizarAbono(cantidad)) completado = true
                }
            }

        } catch (e: IllegalArgumentException){
            println("*ERROR* -> $e")
            return false
        }

        return completado
    }


    override fun toString(): String {
        var cont = 0
        var cuentas: String = "["
        for (i in listaCuentasBancarias){
            ++cont
            if (i != null) cuentas += "$i, "
        }
        cuentas = cuentas.substring(0, cuentas.length - 2)+"]"
        return "Persona(nombre='$nombre', DNI=$dni, cuentas=$cuentas)"
    }
}