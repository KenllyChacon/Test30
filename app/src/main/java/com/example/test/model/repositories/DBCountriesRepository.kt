package com.example.test.model.repositories

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.test.model.dao.CountriesDAO
import com.example.test.model.entities.database.CountriesDB

//Para que no se pueda instanciar
@Database(
    entities = [CountriesDB::class],
    version = 1,
    exportSchema = false//no se puede exportar este esquema, va a hacer de consumo interno
)

abstract class DBCountriesRepository : RoomDatabase(){

    abstract fun getCountriesDao(): CountriesDAO

}

class DBCountriesConnection(){

    fun getConnection(context: Context) = Room.databaseBuilder(context,
            DBCountriesRepository::class.java,
            "DBCountries"
        ).build()
    }
