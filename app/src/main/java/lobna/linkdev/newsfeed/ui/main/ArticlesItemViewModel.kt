package lobna.linkdev.newsfeed.ui.main

import android.view.View
import androidx.databinding.ObservableField
import lobna.linkdev.newsfeed.data.ArticleModel
import lobna.linkdev.newsfeed.utils.Utilities

class ArticlesItemViewModel(
    val item: ArticleModel,
    private val articleInterface: ArticleInterface
) {

    val dateObservable = ObservableField(Utilities.formatDate(item.publishedAt))

    fun onClick(view: View) {
        articleInterface.onItemClick(view.context, item)
    }
}