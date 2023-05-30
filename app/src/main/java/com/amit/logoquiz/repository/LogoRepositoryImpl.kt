package com.amit.logoquiz.repository

import android.content.Context
import android.util.Log
import com.amit.logoquiz.model.LogoQuiz
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import javax.inject.Inject

class LogoRepositoryImpl @Inject constructor(private val context: Context) : LogoRepository {

    override fun loadLogoQuiz() : List<LogoQuiz>{
        lateinit var jsonString: String
        try {
            jsonString = context.assets.open("logoquiz.json")
                .bufferedReader()
                .use { it.readText() }
        } catch (ioException: IOException) {
            Log.d("LogoRepositoryImpl" , ioException.printStackTrace().toString())
        }

        val listCountryType = object : TypeToken<List<LogoQuiz>>() {}.type
        return Gson().fromJson(jsonString, listCountryType)
    }
}