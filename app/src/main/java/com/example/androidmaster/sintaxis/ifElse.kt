package com.example.androidmaster.sintaxis

fun main(){
    ifBasico()
}

fun ifBasico(){
    val name = "Aris"

    if(name == "Pepe"){
        println("Hola")
    }
}

fun ifAnidado(){
    val animal = "Aris"

    if (animal == "dog"){
        println("Perro")
    } else if (animal == "cat"){
        println("gato")
    } else if (animal == "bird"){
        println("pajaro")
    } else {
        println("no es uno de los esperados")
    }
}

fun ifBoolean(){
    var soyFeliz:Boolean = true

    //sin nada == true
    //con ! al principio == false

    if(!soyFeliz){
        println("Triste")
    }
}
