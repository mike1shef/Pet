package com.roadmod.myapplication

import android.widget.TextView
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.Request
import org.jsoup.Jsoup
import java.io.IOException

@OptIn(DelicateCoroutinesApi::class)
fun makeHttpRequest(url: String) : String {
    var title = ""
    GlobalScope.launch(Dispatchers.IO) withContextval@{

        val client = OkHttpClient()
        val request = Request.Builder()
            .url(url)
            .build()

        try {
            val response = client.newCall(request).execute()
            val responseBody = response.body?.string()

            withContext(Dispatchers.Main) {
                val doc = Jsoup.parse(responseBody)
                title = doc.title()
            }
            // Do something with the response body
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
    return title
}