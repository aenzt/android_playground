package com.example.mrhead

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var welcomeText:TextView

    private lateinit var moustacheCheck: CheckBox
    private lateinit var beardCheck:CheckBox
    private lateinit var eyebrowCheckBox: CheckBox
    private lateinit var hairCheckBox: CheckBox

    private lateinit var moustacheImg:ImageView
    private lateinit var beardImg: ImageView
    private lateinit var eyebrowImg: ImageView
    private lateinit var hairImg: ImageView

    private lateinit var buttonContact:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        welcomeText = findViewById(R.id.welcome_email)

        moustacheCheck = findViewById(R.id.moustache_checkbox)
        beardCheck = findViewById(R.id.beard_checkbox)
        eyebrowCheckBox = findViewById(R.id.eyebrow_checkbox)
        hairCheckBox = findViewById(R.id.hair_checkbox)

        moustacheImg = findViewById(R.id.moustache)
        beardImg = findViewById(R.id.beard)
        eyebrowImg = findViewById(R.id.eyebrow)
        hairImg = findViewById(R.id.hair)

        buttonContact = findViewById(R.id.contact_us_button)

        moustacheCheck.isChecked = true
        beardCheck.isChecked=true
        eyebrowCheckBox.isChecked=true
        hairCheckBox.isChecked=true

        val intent = intent
        welcomeText.text = "Welcome, " + intent.getStringExtra("email_key")

        moustacheCheck.setOnClickListener {
            if (moustacheCheck.isChecked) {
                moustacheImg.visibility = View.VISIBLE
            } else {
                moustacheImg.visibility = View.INVISIBLE
            }
        }

        beardCheck.setOnClickListener {
            if (beardCheck.isChecked) {
                beardImg.visibility = View.VISIBLE
            } else {
                beardImg.visibility = View.INVISIBLE
            }
        }

        eyebrowCheckBox.setOnClickListener {
            if (eyebrowCheckBox.isChecked) {
                eyebrowImg.visibility = View.VISIBLE
            } else {
                eyebrowImg.visibility = View.INVISIBLE
            }
        }

        hairCheckBox.setOnClickListener {
            if (hairCheckBox.isChecked) {
                hairImg.visibility = View.VISIBLE
            } else {
                hairImg.visibility = View.INVISIBLE
            }
        }

        buttonContact.setOnClickListener{
            val intentContact = Intent(this@MainActivity, ContactUs::class.java)
            startActivity(intentContact)
        }

    }
}