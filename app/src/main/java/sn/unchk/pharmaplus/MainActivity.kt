package sn.unchk.pharmaplus

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var etIdentifiant: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnForgotPassword: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etIdentifiant = findViewById(R.id.etIdentifiant)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnForgotPassword = findViewById(R.id.btnForgotPassword)

        btnLogin.setOnClickListener {
            val username = etIdentifiant.text.toString()
            val password = etPassword.text.toString()
            authentification(username, password)
        }

        btnForgotPassword.setOnClickListener {
            // Handle forgot password logic
            Toast.makeText(this, "Mot de passe oublié cliqué", Toast.LENGTH_SHORT).show()
        }



        // Ajouter un utilisateur
        val dbManager = DatabaseManager(this)
        dbManager.addAdmin(this, "Mansour ndiaye", "mansour@pharmaplus.com", "Mansour@2K24")

        // Récupérer tous les utilisateurs
        val admins = dbManager.getAllAdmins()
        admins.forEach { admin ->
            println("Email: ${admin.email}, Password: ${admin.password}")
        }
    }
    private fun authentification(username: String, password: String) {
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Veuillez entrer un identifiant et un mot de passe", Toast.LENGTH_SHORT).show()
            return
        }

        val dbManager = DatabaseManager(this)
        val admins = dbManager.getAllAdmins()
        val admin = admins.find { it.email == username && it.password == password }

        if (admin != null) {
            // Connexion réussie
            Toast.makeText(this, "Connexion réussie", Toast.LENGTH_SHORT).show()
            // Naviguer vers la prochaine activité
            val intent = Intent(
                this@MainActivity,
                HomeActivity::class.java
            )
            startActivity(intent)
        } else {
            // Identifiants incorrects
            Toast.makeText(this, "Identifiant ou mot de passe incorrect", Toast.LENGTH_SHORT).show()
        }
    }
}