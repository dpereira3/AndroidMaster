package com.example.androidmaster.sintaxis

fun main(){
    val weekDays= arrayOf("lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo")

    println(weekDays[1])
    println(weekDays.size)

    weekDays[4] = "hola"

    //bucles
    for(position in weekDays.indices){
        println(weekDays[position])
    }

    for((position, value) in weekDays.withIndex()){
        println("La posicion $position, contiene $value")
    }

    for(day in weekDays){
        println("hoy es $day")
    }
}

