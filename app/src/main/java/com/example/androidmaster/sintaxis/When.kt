package com.example.androidmaster.sintaxis

fun main(){
    println(getSemester(4))

    var name:String? = null // el signo ? nullable

    println(name?.get(3) ?: "es null") // operador elvis

}

fun getMonth(month:Int){
    when(month){
        1 -> println("enero")
        2 -> println("febrero")
        3 -> println("marzo")
        4 -> println("abril")
        5 -> println("mayo")
        6 -> println("junio")
        7 -> println("julio")
        8 -> println("agosto")
        9 -> println("septiembre")
        10 -> println("octubre")
        11 -> {
            println("noviembre")
            println("noviembre")
        }
        12 -> println("diciembre")
        else -> println("No es un mes valido")
    }
}

fun getTrimester(month:Int){
                           when(month){
                               1, 2, 3 -> println("Primer trimestre")
                               4, 5, 6 -> println("Primer trimestre")
                               7, 8, 9 -> println("Primer trimestre")
                               10, 11, 12 -> println("Primer trimestre")
                               else -> println("no valido")
                           }
}

fun getSemester(month:Int):String{
    return when(month){
        in 1..6 -> "Primer Semestre"
        in 7..12 -> "Segundo semestre"
        !in 1..12 -> "no valido"
        else -> "dada"
    }
}

fun result(value:Any){
    when(value){
        is Int -> value + value
        is String -> println(value)
        is Boolean -> if(value) println("holiwi")
    }
}

