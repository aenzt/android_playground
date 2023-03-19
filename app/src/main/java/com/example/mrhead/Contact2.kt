package com.example.mrhead

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Contact2 : AppCompatActivity() {
    private lateinit var nimText:TextView
    private lateinit var hpText:TextView
    private lateinit var alamatTextView: TextView
    private lateinit var jenisTextView: TextView

    private lateinit var sendMessageButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact2)

        nimText = findViewById(R.id.nim_text)
        hpText = findViewById(R.id.hp_text)
        alamatTextView = findViewById(R.id.alamat_text)
        jenisTextView = findViewById(R.id.jenis_tempat_text)
        sendMessageButton = findViewById(R.id.kirim_pesan)

        val dataIntent = intent
        nimText.text = "NIM: " + dataIntent.getStringExtra("nim")
        hpText.text = "HP: " + dataIntent.getStringExtra("hp")
        alamatTextView.text = "Alamat: " + dataIntent.getStringExtra("alamat")
        jenisTextView.text = "Jenis Tempat Tinggal: " + dataIntent.getStringExtra("jenis_tempat")

        sendMessageButton.setOnClickListener {
            val url: String = "https://api.whatsapp.com/send/?phone=" + hpText.text.toString() + "&text=NIM%3DNIM" + nimText.text.toString() + "&type=phone_number"
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }
    }
}