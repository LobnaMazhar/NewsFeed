package lobna.linkdev.newsfeed.ui.main

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import lobna.linkdev.newsfeed.data.ArticleModel
import lobna.linkdev.newsfeed.data.ArticleResponse
import lobna.linkdev.newsfeed.data.NewsFeedResponse
import lobna.linkdev.newsfeed.network.NewsFeedApiInterface
import lobna.linkdev.newsfeed.repository.MainRepository
import lobna.linkdev.newsfeed.ui.details.DetailsActivity
import lobna.linkdev.newsfeed.utils.IntentClass

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val isLoadingObservable = ObservableBoolean(true)
    private val mArticles = arrayListOf<ArticleModel>()
    val articlesAdapter = ArticlesAdapter(mArticles, object : ArticleInterface {
        override fun onItemClick(context: Context, item: ArticleModel) {
            val bundle = Bundle()
            bundle.putParcelable("data", item)
            IntentClass.goToActivity(context, DetailsActivity::class.java, bundle)
        }
    })

    init {
        getData()
    }

    private fun getData() {
        isLoadingObservable.set(true)
        viewModelScope.launch(Dispatchers.IO) {
            val response1 =
                async { MainRepository.getArticles(NewsFeedApiInterface.theNextWeb) }
            val response2 =
                async { MainRepository.getArticles(NewsFeedApiInterface.associatedPress) }

            withContext(Dispatchers.Main) { bindResponse(response1.await(), response2.await()) }
        }
    }

    private fun bindResponse(vararg responses: NewsFeedResponse) {
        isLoadingObservable.set(false)
        for (response in responses) {
            when (response) {
                is NewsFeedResponse.ErrorResponse ->
                    Toast.makeText(getApplication(), response.message, Toast.LENGTH_LONG).show()
                is NewsFeedResponse.ExceptionResponse ->
                    Toast.makeText(getApplication(), response.message, Toast.LENGTH_LONG).show()
                is NewsFeedResponse.DataResponse<*> -> {
                    (response.data as? ArticleResponse)?.run {
                        val currentSize = mArticles.size
                        mArticles.addAll(articles)
                        articlesAdapter.notifyItemRangeInserted(currentSize, articles.size)
                    }
                }
            }
        }
    }

}