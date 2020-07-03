package id.midnightminer.newstech.ui.newsCategory

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.midnightminer.newstech.BR
import id.midnightminer.newstech.R
import id.midnightminer.newstech.data.model.News
import id.midnightminer.newstech.databinding.ItemNewsBinding

class NewsCategoryAdapter internal constructor(context: Context) : RecyclerView.Adapter<NewsCategoryAdapter.NewsViewHolder>(){
    var news = emptyList<News>()
    val contexts = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding: ItemNewsBinding = DataBindingUtil.inflate(LayoutInflater.from(contexts), R.layout.item_news,parent, false)
        return NewsViewHolder(binding)
    }

    override fun getItemCount(): Int = news.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(news.get(position))
    }

    class NewsViewHolder(val binding: ItemNewsBinding) :RecyclerView.ViewHolder(binding.root){

        fun bind(data: News){
            binding.setVariable(BR.news, data)
            binding.executePendingBindings()
            binding.containerNews.setOnClickListener {
                var bundle = bundleOf("urlNews" to data.url)
                Navigation.findNavController(it).navigate(R.id.newsToDetail, bundle)
            }
        }
    }

    internal fun setNews(news: List<News>){
        this.news = news
        notifyDataSetChanged()
    }
}