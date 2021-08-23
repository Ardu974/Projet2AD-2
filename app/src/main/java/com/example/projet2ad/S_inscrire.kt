package com.example.projet2ad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class S_inscrire : AppCompatActivity() {
    //La ligne de code ci-dessous est créée suite à la validation d'Inscription
    // ligne30 pour utiliser Firebase
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sinscrire)
        val Nom_Prenom = findViewById<EditText>(R.id.ETNomPrenom)
        val EmaildeConnexion = findViewById<EditText>(R.id.ETEmaildeconnexion)
        val Telephone = findViewById<EditText>(R.id.ETTelephone)
        val MembresFamille = findViewById<EditText>(R.id.MembresFamille)
        val DateDepart = findViewById<EditText>(R.id.Datededepart)
        val Motdepasse1 = findViewById<EditText>(R.id.ETMotdepasse1)
        val Motdepasse2 = findViewById<EditText>(R.id.ETMotdepasse2)
        val Validation_dInscription = findViewById<Button>(R.id.BTValidationInscription)

        //La variable ci-dessous est initialisée, suite à la ligne de code ligne 16
        auth= Firebase.auth

        Validation_dInscription.setOnClickListener{
            // les variables ci-dessous permettent de transformer les données text. en .toString()
            val email = EmaildeConnexion.text.toString()
            val password1 = Motdepasse1.text.toString()
            val password2 = Motdepasse2.text.toString()

            if (Nom_Prenom.text.isEmpty() or EmaildeConnexion.text.isEmpty() or Telephone.text.isEmpty()
                or DateDepart.text.isEmpty() or MembresFamille.text.isEmpty() or Motdepasse1.text.isEmpty()
                or Motdepasse2.text.isEmpty()){
                Toast.makeText(
                    baseContext, "T'as une case vide, mon gars...",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else if (password1 != password2)
            {
                Toast.makeText(
                    baseContext, "Faut le même mot de passe stp...",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else if (password1.length < 6){
                Toast.makeText(
                    baseContext, "Ton mot de passe est trop court...",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else {
                auth.createUserWithEmailAndPassword(email,password1)
                    .addOnCompleteListener (this) { task ->
                        Log.d("Message", task.exception?.message.toString())
                        Log.d("Message", task.exception?.printStackTrace().toString())

                        if (task.isSuccessful){
                            Toast.makeText(
                            baseContext, "Bienvenue à bord !",
                            Toast.LENGTH_SHORT
                        ).show()
                            val seConnecterIntent = Intent(this,MainActivity::class.java)
                            startActivity(seConnecterIntent)
                    }
                        else {
                        Toast.makeText(
                                baseContext, "Ca coince quelque part, l'Ami...!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
            }
        }

    }

}}



