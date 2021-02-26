package com.ctt.primeiroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.ctt.primeiroapp.model.Usuario
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private const val CICLO_VIDA = "CICLOVIDA"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botaoCadastrar = findViewById<Button>(R.id.btnCadastrar)
        val nomeUsuario = findViewById<EditText>(R.id.edtNomeUsuario)
        val idadeUsuario= findViewById<EditText>(R.id.edtIdadeUsuario)

        var contador = 0

        botaoCadastrar.setOnClickListener{
            val nomeDigitado = nomeUsuario.text.toString()
            val idadeDigitada = idadeUsuario.text.toString()

            if (nomeDigitado.isEmpty()){
                if (idadeDigitada.isEmpty()){
                    idadeUsuario.error = "Por favor não esqueça de digitar sua idade!"
                }else{
                    nomeUsuario.error = "Por favor digite seu nome."
                }
            } else{
                val usuario = Usuario(contador++, nomeDigitado, idadeDigitada)
                exibirUsuario(usuario)
            }
        }
    }

    fun exibirUsuario(usuario: Usuario){
        Log.e("USUARIO", usuario.toString()) //pesquisar o erro, facilita na hora de encontrar no logcat
        Toast.makeText(this,"Boas vindas, ${usuario.nome}, ${usuario.idade} anos! Seu id é ${usuario.id}",Toast.LENGTH_LONG).show()
    }


    override fun onStart() {
        super.onStart()
        Log.e(CICLO_VIDA, "App em OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e(CICLO_VIDA, "App em OnResume")
    }

    override fun onStop() {
        super.onStop()
        Log.e(CICLO_VIDA, "App em OnStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(CICLO_VIDA, "App em OnRestart")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.e(CICLO_VIDA, "App em OnStop")
    }