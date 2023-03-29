package com.example.mrhead

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast

class Register : AppCompatActivity() {

    private lateinit var dropdown:Spinner

    private lateinit var emailInput:EditText
    private lateinit var passwordInput:EditText
    private lateinit var namaInput:EditText
    private lateinit var alamatInput:EditText

    private lateinit var registerButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        dropdown = findViewById(R.id.dropdown_menu)
        emailInput = findViewById(R.id.email_input)
        passwordInput = findViewById(R.id.password_input)
        namaInput = findViewById(R.id.nama_input)
        alamatInput = findViewById(R.id.alamat_input)
        registerButton = findViewById(R.id.register_button)

        val adapter = ArrayAdapter.createFromResource(this, R.array.dropdown_item, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
        dropdown.adapter = adapter

        registerButton.setOnClickListener {
            if (emailInput.text.isEmpty() && passwordInput.text.isEmpty() && namaInput.text.isEmpty() && alamatInput.text.isEmpty()){
                Toast.makeText(this, "Form tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }else {
                val intent = Intent().apply {
                    putExtra(EMAIL, emailInput.text.toString())
                    putExtra(PASSWORD, passwordInput.text.toString())
                }
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }

    }

    companion object {
        const val EMAIL = "email"
        const val PASSWORD = "password"
    }
}