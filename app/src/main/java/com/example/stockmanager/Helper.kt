package com.example.stockmanager

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class Helper {
    companion object{
        fun log(content : Any) {
            Log.i("SM", "$content")
        }

        fun toast(context: Context, message: String?) {
            Toast.makeText(context, "$message", Toast.LENGTH_LONG).show()
        }

        inline fun <reified T> parseObject(data: Any, typeToken: Type): T {
            val json: String = Gson().toJson(data)
            val gson = GsonBuilder().create()
            return gson.fromJson(json, typeToken)
        }

        inline fun <reified T> Gson.toArray(json: Any) = fromJson<T>(Gson().toJson(json), object : TypeToken<T>() {}.type)

        fun processErrors(jsonObject: JsonObject?): String {
            var formattedError = ""
            jsonObject?.keySet()?.forEach { key ->
                var errString = ""
                val errors = jsonObject.getAsJsonArray(key)
                errors.forEach {
                    errString += it.asString
                }
                formattedError += "$errString \n"
            }
            return formattedError
        }

    }
}