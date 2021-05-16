package com.proyecto.cdigomorse

import android.R.string
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


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

        val frase: String =  etMsj.text.toString()

        val fraseS: Array<String> = frase.split(",").toTypedArray()

        var aux = arrayListOf<String>()


        /*Log.d("LLegó" , "antes del for")
        for (i in frase.indices){
            Log.d("LLegó" , " antes del for 2")
            for (j in letras.indices){
                if(fraseS[i] == letras[j]){
                        aux.add(letras.get(j))
                    Log.d("LLegó" , " despues de agregar las letras")
                    etmMorse.setText(Cmorse[j])
                }
                    //aux = aux + Cmorse.get(j)



            }
        }*/

        for(i in Cmorse.indices){
            etmMorse.setText(Cmorse[i])
        }

    }

}