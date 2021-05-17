package com.proyecto.cdigomorse

import android.R.string
import android.os.Bundle
import android.text.TextUtils.split
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val etMsj = findViewById<EditText>(R.id.etMsj)
        val etmMorse = findViewById<EditText>(R.id.etMorse)
        val btnTrad = findViewById<Button>(R.id.btn_traducir)
        val btnTrad2 = findViewById<Button>(R.id.btn_traducir2)

        Toast.makeText(this, "Recuerda que el software solo permite mensajes en letra mínuscula", Toast.LENGTH_SHORT).show()


        btnTrad.setOnClickListener {

            if (etMsj.text.isEmpty()) {
                Toast.makeText(this, "Ingrese el texto a traducir", Toast.LENGTH_SHORT).show()
            } else {

                tradMSJ(etmMorse, etMsj)
            }

        }

        btnTrad2.setOnClickListener {

            if (etmMorse.text.isEmpty()) {
                Toast.makeText(this, "Ingrese el código morse a traducir", Toast.LENGTH_SHORT).show()
            } else {
                tradMORSE(etmMorse,etMsj)
            }

        }

    }

    private fun tradMSJ(etmMorse: EditText, etMsj: EditText) {

        //Declaración de dos arrays para el código morse y para el abecedario

        val Cmorse = arrayListOf(".-", "-...", "-.-.", "-..", ".",
                "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...",
                "-", "..-", "...-", ".--", "-..-", "-.--", "--..")

        val ABC = arrayListOf("a", "b", "c", "d", "e",
                "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
                "t", "u", "v", "w", "x", "y", "z")

        //Array auxiliar donde se almacenará el mensaje del usuario

        var aux = arrayListOf<String>()

        // Mensaje de usuario

        var frase: String = etMsj.text.toString()

        //String donde se almacena el código morse despues de traducido

        var txttraducido = ""

        Log.d("LLegó", "antes del for")
        for ((i, v) in frase.withIndex()) { // permite acceder a la posición y el valor de cada letra de la frase
            println("La posición $i tiene el valor $v")
            aux.add(frase[i].toString()) // almacenar datos de la frase en el array auxiliar
            if (aux[i] == " ") { // si hay espacios vacios
                txttraducido = txttraducido + "   " // almacena el espacio junto con los demás datos almacenados en la variable de traducción
            } else {
                for ((j, v) in ABC.withIndex()) { // for del tamaño del ABC para poder recorrer el array de codmorse
                    if (ABC[j] == "$v" && aux[i] == "$v") { // se determinan las letras que son iguales entre el array ABC y la frase (almacenada en aux)
                        Log.d("Se pudo", "si hay simillares") // verifica las letras minusculas iguales y las imprime en consola
                        txttraducido = txttraducido + Cmorse[j] // añade al estado actual de la traducción la nueva palabra traducida en codigo morse
                        Log.d("codtrad", "$txttraducido") // imprime en cada ciclo por medio de la consola el valor de la traducción, termina cuando ya no hay palabras por traducir
                        etmMorse.setText(txttraducido)// muestra en el campo de código morse la palabra traducida
                    }
                }

            }

        }

        for ((i, v) in aux.withIndex()) {
            println("La posición2 $i tiene el valor $v") // recorre el array aux e imprime cada letra en un ciclo distinto
        }

    }


    private fun tradMORSE(etmMorse: EditText, etMsj: EditText) {

        // Para que sea funcional es necesario que al terminar cada letra en codigo morse sea colocado el simbolo "/"
        // de igual forma al iniciar una nueva palabra debe dejarse un espacio y colocar el mismo simbolo "/"
        // por ejemplo las palabras "hola adios" en código morse deben ser escritas de la siguiente forma:
        // "..../---/.-../.-/ /.-/-../../---/..."

        var a = ".-";
        var b = "-...";
        var c = "-.-.";
        var d = "-..";
        var e = "."
        var f = "..-.";
        var g = "--.";
        var h = "....";
        var i = "..";
        var j = ".---"
        var k = "-.-";
        var l = ".-..";
        var m = "--";
        var n = "-.";
        var o = "---"
        var p = ".--.";
        var q = "--.-";
        var r = ".-.";
        var s = "...";
        var t = "-"
        var u = "..-";
        var v = "...-";
        var w = ".--";
        var x = "-..-";
        var y = "-.--";
        var z = "--.."

        val Cmorse = arrayListOf(a, b, c, d, e,
                f, g, h, i, j, k, l, m, n, o, p, q, r, s,
                t, u, v, w, x, y, z)

        val ABC = arrayListOf("a", "b", "c", "d", "e",
                "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
                "t", "u", "v", "w", "x", "y", "z")


            //Array auxiliar donde se almacenará el mensaje del usuario

            var aux = arrayListOf<String>()

            // Mensaje de usuario

            var frase: String = etmMorse.text.toString()

            //String donde se almacena el código morse despues de traducido

            var txttraducido = ""

            Log.d("LLegó", "antes del for")
            // for ((i,v) in frase.withIndex()){ // permite acceder a la posición y el valor de cada letra de la frase
            val partes = frase.split("/")
            for ((i, v) in partes.withIndex()) { // permite acceder a la posición y el valor de cada letra de la frase
                println("La posición $i tiene el valor $v")
                if (partes[i] == " ") { // si hay espacios vacios
                    txttraducido = txttraducido + " " // almacena el espacio junto con los demás datos almacenados en la variable de traducción
                } else {
                    for ((j, v) in Cmorse.withIndex()) { // for del tamaño del ABC para poder recorrer el array de codmorse
                        //if(Cmorse[j] == "$v" && aux[i] == "$v" ){ // se determinan las letras que son iguales entre el array ABC y la frase (almacenada en aux)
                        if (Cmorse[j] == "$v" && partes[i] == "$v") { // se determinan las letras que son iguales entre el array ABC y la frase (almacenada en aux)
                            Log.d("Se pudo", "si hay simillares") // verifica las letras minusculas iguales y las imprime en consola
                            txttraducido = txttraducido + ABC[j]// añade al estado actual de la traducción la nueva palabra traducida en codigo morse
                            Log.d("codtrad", "$txttraducido") // imprime en cada ciclo por medio de la consola el valor de la traducción, termina cuando ya no hay palabras por traducir
                            etMsj.setText(txttraducido)// muestra en el campo de código morse la palabra traducida
                        }
                    }

                }

            }

            for ((i, v) in aux.withIndex()) {
                println("La posición2 $i tiene el valor $v") // recorre el array aux e imprime cada letra en un ciclo distinto
            }


        }



}

