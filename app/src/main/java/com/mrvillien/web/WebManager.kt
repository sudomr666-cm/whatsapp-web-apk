package com.mrvillien.web

import android.content.Context
import android.view.View
import android.webkit.*

object WebManager {

    private val pool = HashMap<String, WebView>()

    fun preload(context: Context, key: String, url: String) {
        if (pool.containsKey(key)) return

        val web = WebView(context.applicationContext)
        val s = web.settings

        s.javaScriptEnabled = true
        s.domStorageEnabled = true
        s.databaseEnabled = true
        s.cacheMode = WebSettings.LOAD_DEFAULT
        s.loadsImagesAutomatically = true
        s.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW

        web.setLayerType(View.LAYER_TYPE_HARDWARE, null)

        web.webViewClient = WebViewClient()
        web.webChromeClient = WebChromeClient()

        web.loadUrl(url)

        pool[key] = web
    }

    fun get(key: String): WebView? = pool[key]
}
