package sn.unchk.pharmaplus

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class DatabaseManager (context: Context){
    private val dbHelper: DatabasePharmaPlus = DatabasePharmaPlus(context)
    //La fonction Add Admin
    fun addAdmin(context: Context, name: String, email: String, password: String) {
        val dbHelper = DatabasePharmaPlus(context)
        val db: SQLiteDatabase = dbHelper.writableDatabase

        val values = ContentValues().apply {
            put(DatabasePharmaPlus.COLUMN_NAME, name)
            put(DatabasePharmaPlus.COLUMN_EMAIL, email)
            put(DatabasePharmaPlus.COLUMN_PASSWORD, password)
        }

        db.insert(DatabasePharmaPlus.TABLE_ADMINS, null, values)
        db.close()
    }
}