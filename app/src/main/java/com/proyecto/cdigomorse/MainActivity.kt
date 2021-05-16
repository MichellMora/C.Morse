package com.proyecto.cdigomorse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlin.text.isEmpty as isEmpty

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val etMsj = findViewById<EditText>(R.id.etMsj)
        val etmMorse = findViewById<EditText>(R.id.etMorse)
        val btnTrad = findViewById<Button>(R.id.btn_traducir)
        val btnTrad2 = findViewById<Button>(R.id.btn_traducir2)

        btnTrad.setOnClickListener {

            if (etMsj.text.isEmpty()) {
                Toast.makeText(this, "Ingrese el texto a traducir", Toast.LENGTH_SHORT).show()
            } else {

                tradMSJ (etmMorse, etMsj)
            }

        }

        btnTrad2.setOnClickListener {

            if (etmMorse.text.isEmpty()) {
                Toast.makeText(this, "Ingrese el código morse a traducir", Toast.LENGTH_SHORT).show()
            } else {

               // tradMORSE(etmMorse,etMsj)
            }

        }

    }

    private fun tradMSJ(etmMorse:EditText, etMsj:EditText){

       val letras = arrayOf("a","b","c","d","e",
       "f","g","h","i","j","k","m","l","n","o","p","q","r","s",
       "t","u","v","w","x","y","z")

        val Cmorse = arrayOf(".-","-...","-.-.","-..",".",
                "..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...",
                "-","..-","...-",".--","-..-","-.--","--..")

        for (letra in 0..25){
            for (l in letras)
            if (etMsj.text.toString() == letras[letra]){
                for (morse in Cmorse){
                    /*letras.get(2) == Cmorse.get(morse.toInt())*/

                    etmMorse.setText(Cmorse.get(letra))
                }

                }


            }


    }





}






