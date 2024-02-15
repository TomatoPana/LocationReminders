package com.example.locationreminders

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var gridListButton: Button
    private lateinit var presentationViewButton: Button
    private lateinit var loginViewButton: Button
    private lateinit var registerViewButton: Button
    private lateinit var createEditViewButton: Button
    private lateinit var mapViewButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gridListButton = findViewById(R.id.button)
        gridListButton.setOnClickListener {
            val intent = Intent(this, GridListActivity::class.java)
            startActivity( intent )
        }
        presentationViewButton = findViewById(R.id.button2)
        presentationViewButton.setOnClickListener {
            val intent = Intent(this, PresentationActivity::class.java)
            startActivity( intent )
        }
        loginViewButton = findViewById(R.id.button3)
        loginViewButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity( intent )
        }
        registerViewButton = findViewById(R.id.button4)
        registerViewButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity( intent )
        }
        createEditViewButton = findViewById(R.id.button5)
        createEditViewButton.setOnClickListener {
            val intent = Intent(this, EditNoteActivity::class.java)
            startActivity( intent )
        }
        mapViewButton = findViewById(R.id.button6)
        mapViewButton.setOnClickListener {
            val intent = Intent(this, MapListActivity::class.java)
            startActivity( intent )
        }
    }
}
