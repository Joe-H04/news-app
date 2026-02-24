package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.app.Activity

data class NewsItem(val title: String, val description: String, val imageResId: Int)

class NewsAdapter(context: Context, private val newsList: ArrayList<NewsItem>) : ArrayAdapter<NewsItem>(context, 0, newsList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val currentItem = newsList[position]
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_news, parent, false)
        val imageView = view.findViewById<ImageView>(R.id.newsImage)
        val titleTextView = view.findViewById<TextView>(R.id.newsTitle)
        val descriptionTextView = view.findViewById<TextView>(R.id.newsDescription)
        imageView.setImageResource(currentItem.imageResId)
        titleTextView.text = currentItem.title
        descriptionTextView.text = currentItem.description
        return view
    }
}

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newsList = ArrayList<NewsItem>()
        newsList.add(NewsItem("Lebanon Celebrates Tech Festival", "Hundreds of developers gathered in Beirut for the annual tech expo showcasing local startups.", R.mipmap.ic_launcher))
        newsList.add(NewsItem("SpaceX Launches New Satellite", "A new batch of Starlink satellites was successfully deployed into low Earth orbit yesterday.", R.mipmap.ic_launcher_round))
        newsList.add(NewsItem("AI Beats Humans at Chess Again", "The latest AI model from DeepMind achieved a perfect score against top grandmasters worldwide.", R.mipmap.ic_launcher))
        newsList.add(NewsItem("Stock Markets Hit Record Highs", "Major indices surged today as investors reacted positively to new economic data from the US.", R.mipmap.ic_launcher_round))
        newsList.add(NewsItem("New Android Version Released", "Google announced Android 16 with exciting new features for developers and end users alike.", R.mipmap.ic_launcher))
        newsList.add(NewsItem("Climate Summit Reaches Agreement", "World leaders signed a landmark deal to reduce carbon emissions by 50% before 2035.", R.mipmap.ic_launcher_round))

        val adapter = NewsAdapter(this, newsList)
        val listView = findViewById<ListView>(R.id.newsListView)
        listView.adapter = adapter
        listView.dividerHeight = 2
    }
}