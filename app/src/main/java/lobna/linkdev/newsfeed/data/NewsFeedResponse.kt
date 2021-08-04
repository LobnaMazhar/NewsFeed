package lobna.linkdev.newsfeed.data

sealed class NewsFeedResponse {
    data class ErrorResponse(val code: Int, val message: String) : NewsFeedResponse()
    data class ExceptionResponse(val message: String?) : NewsFeedResponse()
    data class DataResponse<T>(val data: T) : NewsFeedResponse()
}