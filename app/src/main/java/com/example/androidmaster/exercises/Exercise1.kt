package com.example.androidmaster.exercises

fun main(){
    val morningNotificacion = 51
    val eveningNotification = 135

    printNotificationSummary(morningNotificacion)
    printNotificationSummary(eveningNotification)
}

fun printNotificationSummary(numberOfMessages:Int){
    if(numberOfMessages >=100){
        println("you got 99+")
    } else {
        println("you have $numberOfMessages notifications")
    }
}