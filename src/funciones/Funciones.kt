package funciones

fun <T> Iterable<T>.contar(elemento: T): Int{
    var cuenta = 0
    for (i in this){
        if (i == elemento) cuenta ++
    }
    return cuenta
}