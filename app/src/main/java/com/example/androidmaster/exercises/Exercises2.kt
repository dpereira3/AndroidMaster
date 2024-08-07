package com.example.androidmaster.exercises

fun main(){
    val child = 5
    val adult = 28
    val senior = 87

    val isMonday = true

    println(" para $child is \$${ticketPrice(child, isMonday)}")
    println(" para $adult is \$${ticketPrice(adult, isMonday)}")
    println(" para $senior is \$${ticketPrice(senior, isMonday)}")
}

fun ticketPrice(age:Int, isMonday:Boolean): Int {
    return when(age){
        in 0..12 -> 15
        in 13..60 -> if(isMonday) 25 else 30
        in 61..100 -> 20
        else -> -1
    }
}