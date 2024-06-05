package sn.unchk.pharmaplus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


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
        val users = dbManager.getAllAdmins()
        users.forEach { admin ->
            println("Admin: ${admin.name}, Email: ${admin.email}")
        }
    }
    private fun authentification(username: String, password: String) {
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Veuillez entrer un identifiant et un mot de passe", Toast.LENGTH_SHORT).show()
            return
        }

        val dbManager = DatabaseManager(this)
        val users = dbManager.getAllAdmins()
        val user = users.find { it.name == username && it.email == password }

        if (user != null) {
            // Connexion réussie
            Toast.makeText(this, "Connexion réussie", Toast.LENGTH_SHORT).show()
            // Naviguer vers la prochaine activité
        } else {
            // Identifiants incorrects
            Toast.makeText(this, "Identifiant ou mot de passe incorrect", Toast.LENGTH_SHORT).show()
        }
    }
}