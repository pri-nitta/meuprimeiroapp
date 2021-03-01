package com.ctt.primeiroapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.ctt.primeiroapp.model.Usuario
import kotlinx.android.synthetic.main.activity_main.*
private const val CICLO_VIDA = "CICLOVIDA"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botaoCadastrar = findViewById<Button>(R.id.btnCadastrar)
        val nomeUsuario = findViewById<EditText>(R.id.edtNomeUsuario)
        val idadeUsuario = findViewById<EditText>(R.id.edtIdadeUsuario)

        var contador = 0

        botaoCadastrar.setOnClickListener {
            val nomeDigitado = nomeUsuario.text.toString()
            val idadeDigitada = idadeUsuario.text.toString()

            if (nomeDigitado.isEmpty()) {
                if (idadeDigitada.isEmpty()) {
                    idadeUsuario.error = "Por favor não esqueça de digitar sua idade!"
                } else {
                    nomeUsuario.error = "Por favor digite seu nome."
                }
            } else {
                val usuario = Usuario(contador++, nomeDigitado, idadeDigitada)
                exibirUsuario()
            }
        }
    }

    fun exibirUsuario() {
        Toast.makeText(
            this, "Usuário cadastrado com sucesso!",
            Toast.LENGTH_LONG
        ).show()

        redirecionar()
    }

    fun redirecionar() {
        val destinoActivity = Intent(this, UsuarioActivity::class.java)
        startActivity(destinoActivity)
        finish()
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

    override fun onBackPressed() {
        super.onBackPressed()
        Toast.makeText(
            this, "vlw flw",
            Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(CICLO_VIDA, "App em OnStop")
    }
}