package com.example.projet2ad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Entrez les variables ici, comme les boutons
        val BoutonSinscrire = findViewById<Button>(R.id.BTSinscrire)
        val BoutonSeConnecter = findViewById<Button>(R.id.BTSeconnecter)
        val BoutonMotdepasseOublie = findViewById<Button>(R.id.BTMotdepasseoublie)

        //Entrez ensuite les actions attendues des boutons
       BoutonSinscrire.setOnClickListener{
           val SinscrireIntent = Intent(this,S_inscrire::class.java)
           startActivity(SinscrireIntent)
       }





    }
}