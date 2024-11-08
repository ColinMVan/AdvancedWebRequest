package com.example.advancedwebrequest

import android.os.Bundle
import android.util.Base64
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val webv : WebView = findViewById(R.id.mywebview)
        webv.webViewClient = MyWebViewClient()
        webv.settings.javaScriptEnabled = true
//        webv.loadUrl("https://www.iu.edu")

        val unencodedHtml ="<html><body><iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d873.1126651584983!2d-86.52701141684541!3d39.18097828886472!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x886c66cc1c54621f%3A0x9b14fde5e5641040!2sIndiana%20University%20Memorial%20Stadium!5e0!3m2!1sen!2sus!4v1730746720245!5m2!1sen!2sus\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe></body></html>";
        val encodedHtml = Base64.encodeToString(unencodedHtml.toByteArray(), Base64.NO_PADDING)
        webv.loadData(encodedHtml, "text/html", "base64")

    }

    private class MyWebViewClient : WebViewClient() {
    }
}