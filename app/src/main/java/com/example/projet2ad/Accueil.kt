package com.example.projet2ad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Accueil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accueil)
        setTitle("Bienvenue aux Pirates!")
    }
}