package com.mrvillien.session

import android.webkit.CookieManager
import android.webkit.WebView

object SessionManager {
    fun isExpired(webView: WebView): Boolean {
        val cookie = CookieManager.getInstance().getCookie(webView.url ?: "")
        return cookie.isNullOrEmpty()
    }
}
