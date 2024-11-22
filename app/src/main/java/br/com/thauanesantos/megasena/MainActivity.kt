package br.com.thauanesantos.megasena

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random

class MainActivity : AppCompatActivity() {
    private lateinit var editNumero   : EditText
    private lateinit var txtResult    : TextView
    private lateinit var btnGenerator : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editNumero = findViewById(R.id.edit_numero)
        txtResult = findViewById(R.id.txt_resultado)
        btnGenerator = findViewById(R.id.btn_gerar)

        btnGenerator.setOnClickListener {
            val text = editNumero.text.toString()

            numberGenerator(text, txtResult)
        }
    }

    private fun numberGenerator(text: String, txtResult: TextView?) {
        if ( text.isNotEmpty() ){
            val qtd = text.toInt()
            if ( qtd >= 6 && qtd <= 15 ){
                val random  = Random()
                val numbers = mutableSetOf<Int>()

                while (true){
                    val number = random.nextInt(60)
                    numbers.add(number + 1)

                    if( numbers.size == qtd){
                        break
                    }
                }
            } else {
                Toast.makeText(this, "Digite um número entre 6 e 15!",
                    Toast.LENGTH_LONG).show()
            }
        }
    }else {
        Toast.makeText(this, "Esse campo não pode ficar em branco",
            Toast.LENGTH_LONG).show()
    }

}