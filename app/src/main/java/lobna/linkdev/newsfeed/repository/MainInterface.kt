package lobna.linkdev.newsfeed.repository

import lobna.linkdev.newsfeed.data.NewsFeedResponse

interface MainInterface {

    suspend fun getArticles(source: String): NewsFeedResponse
}