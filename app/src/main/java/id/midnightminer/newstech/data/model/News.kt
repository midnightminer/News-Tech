package id.midnightminer.newstech.data.model

data class News (
    var source: Source,
    var author: String,
    var title: String,
    var description: String,
    var url: String,
    var urlToImage: String,
    var publishedAt: String
)

class Source(
    var id: String,
    var name: String
)
