package com.example.androidmaster.sintaxis

fun main(){
    //inmutableList()
    mutableList()
}

fun inmutableList(){
    val readOnly:List<String> = listOf("lunes", "martes", "miercoles", "jueves", "viernes")
    println(readOnly.size)
    println(readOnly) //igual a agregar .toString()

    println(readOnly[3])

    val example = readOnly.filter { it.contains("a")  }
    println(example)

    readOnly.forEach { day -> println(day)}
}

fun mutableList(){
    val weekDays:MutableList<String> = mutableListOf("lunes", "martes", "miercoles", "jueves", "viernes")
    weekDays.add(0,"Aris")
    println(weekDays)

    if(weekDays.isEmpty()){
        // lista vacia
    }else {
        weekDays.forEach { println(it)}
    }
}