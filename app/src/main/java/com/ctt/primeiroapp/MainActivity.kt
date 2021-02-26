package com.ctt.primeiroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.ctt.primeiroapp.model.Usuario
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mensagem = "Usuário cadastrado com sucesso!"
        val botaoCadastrar = findViewById<Button>(R.id.btnCadastrar)
        val nomeUsuario = findViewById<EditText>(R.id.edtNomeUsuario)

        var contador = 0

        botaoCadastrar.setOnClickListener{
            val nomeDigitado = nomeUsuario.text.toString()
            if (nomeDigitado.isEmpty()){
                nomeUsuario.error = "Por favor digite seu nome."
            } else{
                val usuario = Usuario(contador++, nomeDigitado)
                exibirUsuario(usuario)
            }
        }

    }

    fun exibirUsuario(usuario: Usuario){
        Toast.makeText(this,"Boas vindas, ${usuario.nome}! Seu id é ${usuario.id}",Toast.LENGTH_LONG).show()
    }

    fun exibirMensagemErro(){
        Toast.makeText(this, "Por favor, insira seu nome", Toast.LENGTH_SHORT)
    }
}