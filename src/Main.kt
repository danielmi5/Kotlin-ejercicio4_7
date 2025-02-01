
fun main(){
    val persona = Persona("Juan","111111111B")
    val cuenta1 = Cuenta("111",)
    val cuenta2 = Cuenta("02", 700.0)

    try {
        persona.aniadirCuenta(cuenta1)
        println("Cuenta añadida con éxito")
        persona.aniadirCuenta(cuenta2)
        println("Cuenta añadida con éxito")
    } catch (e: IndexOutOfBoundsException){
        println("*ERROR* -> $e")
    }

    cuenta1.realizarAbono(1100.0)
    cuenta2.realizarPago(750.0)

    if (persona.esMorosa()) println("${persona.nombre} es una persona morosa") else println("${persona.nombre} no es una persona morosa")

    persona.realizarTransferencia(persona, "111", "02", 100.0)

    if (persona.esMorosa()) println("${persona.nombre} es una persona morosa") else println("${persona.nombre} no es una persona morosa")

        println("El estado de persona:\n$persona")

}