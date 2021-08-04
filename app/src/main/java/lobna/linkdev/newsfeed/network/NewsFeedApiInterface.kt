package lobna.linkdev.newsfeed.network

import lobna.linkdev.newsfeed.BuildConfig
import lobna.linkdev.newsfeed.data.ArticleResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsFeedApiInterface {

    companion object {
        val theNextWeb = "the-next-web"
        val associatedPress = "associated-press"
    }

    @GET("articles")
    suspend fun getArticles(
        @Query("source") source: String,
        @Query("apiKey") appId: String = BuildConfig.NEWS_FEED_API_KEY
    ): Response<ArticleResponse>
}