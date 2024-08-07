package com.example.androidmaster.sintaxis

//VARIABLES

//Int
val age:Int = 50 //variable de clase, queda como global

fun main(){
    //print("Hola")

    variablesNumericas()

    // Variables Alfanumericas

    val name = "Damian"

    //Char
    val charExample:Char = 'A'

    //String
    val stringExample:String = "Damian Prueba texto {{{"

    // Variables booleanas

    //Boolean
    val booleanExample:Boolean = true

    print(stringExample)

    // Aritmeticas

    println( "Suma:" + (age + age))
    println("restar:" + (age - age))

    println("Hola soy $name y tengo $age años")

    showMyAge(45)

    val mysub = subtract(10, 50)
    println(mysub)
}

fun variablesNumericas(){


    //age = 40 val no puede cambiarse

    var age2:Int = 30
    println(age2)
    age2 = 29 //puede cambiarse el valor
    println(age2)

    //Long
    val example:Long = 30

    //Float
    val floatExample:Float = 5.75f

    //Double
    val doubleExample:Double = 2345.2562456

}

fun showMyAge(currentAge:Int) {
    println("Tengo $currentAge años")
}

fun subtract(num1:Int, num2:Int):Int {
    return num1 - num2
}