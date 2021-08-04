package lobna.linkdev.newsfeed.ui

import android.content.Context
import lobna.linkdev.newsfeed.data.ArticleModel

interface ArticleInterface {

    fun onItemClick(context: Context, item: ArticleModel)
}