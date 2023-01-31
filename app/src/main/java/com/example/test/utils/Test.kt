package com.example.test.utils

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.example.test.model.repositories.DBCountriesConnection
import com.example.test.model.repositories.DBCountriesRepository

class Test : Application() {

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    companion object {

        private val dbCon: DBCountriesConnection? = null

        @SuppressLint("StaticFieldLeak")
        var context: Context? = null

        fun getConn(): DBCountriesRepository {
            return if (dbCon == null) {
                return DBCountriesConnection().getConnection(context!!)
            } else {
                dbCon
            }
        }
    }
}