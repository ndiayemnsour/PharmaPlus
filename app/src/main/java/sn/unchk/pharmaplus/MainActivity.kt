package sn.unchk.pharmaplus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ajouter un utilisateur
        val dbManager = DatabaseManager(this)
        dbManager.addAdmin(this, "Mansour ndiaye", "mansour@pharmaplus.com", "Mansour@2K24")
    }
}