package com.example.projet2ad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ReinitialisationMDP : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reinitialisation_mdp)
        setTitle("T'as oublié ton mot de passe, morbleu ?!")
        auth= Firebase.auth
        val emailreinitialisationMDP = findViewById<TextView>(R.id.ETMaildereinitialisation)
        val boutondereinitialisationMDP = findViewById<Button>(R.id.BTReinitialisation)

        boutondereinitialisationMDP.setOnClickListener{
            val emailreinitialisationMDP = emailreinitialisationMDP.text.toString()
            Firebase.auth.sendPasswordResetEmail(emailreinitialisationMDP)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        Toast.makeText(baseContext, "Mail envoyé",
                            Toast.LENGTH_SHORT
                        ).show()
                        val boutondereinitialisationMDP = Intent(this,S_inscrire::class.java)
                        startActivity(boutondereinitialisationMDP)
                    }
                }
        }
    }
}
