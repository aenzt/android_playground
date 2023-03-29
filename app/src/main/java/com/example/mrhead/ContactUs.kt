package com.example.mrhead

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.util.Date

class ContactUs : AppCompatActivity() {

    private lateinit var emailButton: Button
    private lateinit var callButton: Button
    private lateinit var whatsappButton: Button
    private lateinit var webButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_us)
        emailButton = findViewById(R.id.email_button_contact)
        callButton = findViewById(R.id.call_button_contact)
        whatsappButton = findViewById(R.id.wa_button_contact)
        webButton = findViewById(R.id.web_button_contact)

        emailButton.setOnClickListener {
            composeEmail("raihanpl10@gmail.com", "APP CONTACT-" + Date().toString())
        }

        callButton.setOnClickListener {
            dialPhone("+62812345678")
        }

        whatsappButton.setOnClickListener {
            sendWhatsapp("+62812345678")
        }

        webButton.setOnClickListener {
            openWebsite("https://www.youtube.com/watch?v=dQw4w9WgXcQ")
        }
    }

    private fun composeEmail(address:String, subject:String){
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:")
        intent.putExtra(Intent.EXTRA_EMAIL, address)
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)

        try {
            startActivity(Intent.createChooser(intent, "Choose Email Client"))
        } catch (e: Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun dialPhone(phoneNumber:String){
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse("tel:$phoneNumber")
        try {
            startActivity(Intent.createChooser(callIntent, "Choose"))
        } catch (e: Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun sendWhatsapp(phoneNumber: String){
        val url = "https://api.whatsapp.com/send?phone=$phoneNumber"
        val whatsappIntent = Intent(Intent.ACTION_VIEW)
        whatsappIntent.data = Uri.parse(url)

        try {
            startActivity(whatsappIntent)
        } catch (e:Exception) {
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun openWebsite(url: String){
        val webIntent = Intent(Intent.ACTION_VIEW)
        webIntent.data = Uri.parse(url)
        startActivity(webIntent)
    }
}