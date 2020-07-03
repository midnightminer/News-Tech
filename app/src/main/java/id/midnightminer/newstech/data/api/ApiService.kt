package id.midnightminer.newstech.data.api

import id.midnightminer.newstech.data.model.NewsResponse
import id.midnightminer.newstech.util.Constant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("?pageSize=10")
    fun getNews(
        @Query("page") page: Int,
        @Query("category") category: String)
    : Call<NewsResponse>
}