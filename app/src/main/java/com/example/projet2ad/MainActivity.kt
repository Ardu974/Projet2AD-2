package com.example.projet2ad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Entrez les variables ici, comme les boutons
        val boutonSinscrire = findViewById<Button>(R.id.BTSinscrire)
        val boutonSeConnecter = findViewById<Button>(R.id.BTSeconnecter)
        val boutonMotdepasseOublie = findViewById<Button>(R.id.BTMotdepasseoublie)
        val Motdepassedeconnexion = findViewById<TextView>(R.id.ETMotdepassedinscription)
        val ETEmaildinscription = findViewById<TextView>(R.id.ETEmaildinscription)
        val boutonReglesduJeu = findViewById<Button>(R.id.btreglesdujeu)
setTitle("La Chasse au Trésor de 'Black Widow'")
        auth= Firebase.auth
        //Entrez ensuite les actions attendues des boutons
       boutonSinscrire.setOnClickListener{
           val sinscrireIntent = Intent(this,S_inscrire::class.java)
           startActivity(sinscrireIntent)
       }
        boutonSeConnecter.setOnClickListener{
            val motdepassepourseconnecter = Motdepassedeconnexion.text.toString()
            val emaildinscription = ETEmaildinscription.text.toString()
            auth.signInWithEmailAndPassword(emaildinscription,motdepassepourseconnecter)
                .addOnCompleteListener (this) { task ->
                    if (task.isSuccessful){
                        Toast.makeText(
                            baseContext, "Bienvenue à bord, Pirate !",
                            Toast.LENGTH_SHORT
                        ).show()
                        val accueilIntent = Intent(this,Accueil::class.java)
                        startActivity(accueilIntent)
                    }
                    else {
                        Toast.makeText(
                            baseContext, "T'aurais pas abusé du rhum..?",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
        boutonMotdepasseOublie.setOnClickListener{
            val ReinitialisationMDPIntent = Intent( this, ReinitialisationMDP::class.java)
            startActivity(ReinitialisationMDPIntent)
            }
        boutonReglesduJeu.setOnClickListener{
            val reglesdujeuIntent = Intent( this, reglesdujeu::class.java)
            startActivity(reglesdujeuIntent)
        }

        }
    }

