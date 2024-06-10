package sn.unchk.pharmaplus

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
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

    fun getAllAdmins(): List<Admin> {
        val db: SQLiteDatabase = dbHelper.readableDatabase

        val projection = arrayOf(DatabasePharmaPlus.COLUMN_ID, DatabasePharmaPlus.COLUMN_NAME, DatabasePharmaPlus.COLUMN_EMAIL, DatabasePharmaPlus.COLUMN_PASSWORD)

        val cursor: Cursor = db.query(
            DatabasePharmaPlus.TABLE_ADMINS,
            projection,
            null,
            null,
            null,
            null,
            null
        )

        val admins = mutableListOf<Admin>()
        with(cursor) {
            while (moveToNext()) {
                val id = getLong(getColumnIndexOrThrow(DatabasePharmaPlus.COLUMN_ID))
                val name = getString(getColumnIndexOrThrow(DatabasePharmaPlus.COLUMN_NAME))
                val email = getString(getColumnIndexOrThrow(DatabasePharmaPlus.COLUMN_EMAIL))
                val password = getString(getColumnIndexOrThrow(DatabasePharmaPlus.COLUMN_PASSWORD))
                admins.add(Admin(id, name, email, password))
            }
        }
        cursor.close()
        db.close()

        return admins
    }
}