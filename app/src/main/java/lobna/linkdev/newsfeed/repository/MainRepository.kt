package lobna.linkdev.newsfeed.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import lobna.linkdev.newsfeed.data.NewsFeedResponse
import lobna.linkdev.newsfeed.network.MyRetrofitClient
import lobna.linkdev.newsfeed.network.NewsFeedApiInterface

object MainRepository : MainInterface {

    private var newsFeedApi: NewsFeedApiInterface =
        MyRetrofitClient.createService(NewsFeedApiInterface::class.java)

    override suspend fun getArticles(source: String): NewsFeedResponse {
        return try {
            val response = newsFeedApi.getArticles(source)

            if (response.isSuccessful) {
                NewsFeedResponse.DataResponse(response.body())
            } else {
                NewsFeedResponse.ErrorResponse(response.code(), response.message())
            }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) { e.printStackTrace() }
            NewsFeedResponse.ExceptionResponse(e.message)
        }
    }
}