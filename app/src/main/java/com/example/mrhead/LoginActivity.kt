package com.example.mrhead

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var loginButton:Button
    private lateinit var emailInput:EditText
    private lateinit var passwordInput:EditText

    private lateinit var regEmail: String
    private lateinit var regPasssword: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton = findViewById(R.id.login_button)
        emailInput = findViewById(R.id.email_input)
        passwordInput = findViewById(R.id.password_input)

        loginButton.setOnClickListener {
            val email: String = emailInput.text.toString()
            val password: String = passwordInput.text.toString()

            if (email.isBlank() && password.isBlank()) {
                Toast.makeText(
                    this@LoginActivity,
                    "Email dan password tidak boleh kosong",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                if (email == regEmail && password == regPasssword) {
                    emailInput.text.clear()
                    passwordInput.text.clear()
                    Toast.makeText(this@LoginActivity, "Berhasil Login", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    intent.putExtra("email_key", email)
                    intent.putExtra("password_key", password)
                    startActivity(intent)
                } else {
                    passwordInput.text.clear()
                    Toast.makeText(this@LoginActivity, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun registerIntent(view:View){
        val intent = Intent(this, Register::class.java)
        resultLauncher.launch(intent)
    }

    private var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            regEmail = data?.getStringExtra("email").toString()
            regPasssword = data?.getStringExtra("password").toString()
        }
    }
}