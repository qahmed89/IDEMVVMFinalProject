package com.ahmed.idemvvmfinalproject.adpater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ahmed.idemvvmfinalproject.R
import com.ahmed.idemvvmfinalproject.model.topheadlines.Article

class NewsAdapter(val articles: List<Article>) : RecyclerView.Adapter<NewsAdapter.NewViewHolder>() {

    inner class NewViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvAuthor: TextView = itemView.findViewById(R.id.tvAuthor)
        val tvDescriation: TextView = itemView.findViewById(R.id.tvDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewViewHolder {
        val viewHolder: View = LayoutInflater.from(parent.context).inflate(
            R.layout.news_item,
            parent,
            false
        )
        return NewViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {
        val article = articles[position]
        holder.tvAuthor.text = article.author
        holder.tvDescriation.text = article.description
    }

    override fun getItemCount(): Int {
        return articles.size
    }
}