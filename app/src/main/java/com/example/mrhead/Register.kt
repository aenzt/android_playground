package com.example.mrhead

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

class Register : AppCompatActivity() {

    private lateinit var dropdown:Spinner

    private lateinit var nimInput:EditText
    private lateinit var hpInput:EditText
    private lateinit var namaInput:EditText
    private lateinit var alamatInput:EditText

    private lateinit var registerButton:Button
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        dropdown = findViewById(R.id.dropdown_menu)
        nimInput = findViewById(R.id.nim_input)
        hpInput = findViewById(R.id.hp_input)
        namaInput = findViewById(R.id.nama_input)
        alamatInput = findViewById(R.id.alamat_input)
        registerButton = findViewById(R.id.register_button)
        loginButton = findViewById(R.id.login_button)

        val adapter = ArrayAdapter.createFromResource(this, R.array.dropdown_item, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
        dropdown.adapter = adapter

        registerButton.setOnClickListener {
            val intent = Intent(this@Register, Contact2::class.java)
            intent.putExtra("nim", nimInput.text.toString())
            intent.putExtra("hp", hpInput.text.toString())
            intent.putExtra("nama", namaInput.text.toString())
            intent.putExtra("alamat", alamatInput.text.toString())
            intent.putExtra("jenis_tempat", dropdown.selectedItem.toString())
            startActivity(intent)
        }

        loginButton.setOnClickListener{
            val intentLogin = Intent(this@Register, LoginActivity::class.java)
            startActivity(intentLogin)
        }
    }
}