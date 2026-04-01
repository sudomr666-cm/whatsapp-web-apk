package com.mrvillien

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import android.webkit.WebView
import com.mrvillien.web.WebManager

class MainActivity : AppCompatActivity() {

    lateinit var pager: ViewPager2
    val webViews = ArrayList<WebView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pager = findViewById(R.id.viewPager)

        WebManager.preload(this,"whatsapp","https://web.whatsapp.com")
        WebManager.preload(this,"facebook","https://m.facebook.com")
        WebManager.preload(this,"instagram","https://www.instagram.com")

        webViews.add(WebManager.get("whatsapp")!!)
        webViews.add(WebManager.get("facebook")!!)
        webViews.add(WebManager.get("instagram")!!)

        pager.adapter = object : androidx.recyclerview.widget.RecyclerView.Adapter<ViewHolder>() {
            override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): ViewHolder {
                return ViewHolder(webViews[viewType])
            }
            override fun getItemCount(): Int = webViews.size
            override fun onBindViewHolder(holder: ViewHolder, position: Int) {}
        }
    }

    class ViewHolder(val web: WebView) : androidx.recyclerview.widget.RecyclerView.ViewHolder(web)
}
