package lobna.linkdev.newsfeed.ui.details

import android.os.Bundle
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import lobna.linkdev.newsfeed.data.ArticleModel
import lobna.linkdev.newsfeed.utils.IntentClass
import lobna.linkdev.newsfeed.utils.SingleLiveEvent
import lobna.linkdev.newsfeed.utils.Utilities

class DetailsViewModel : ViewModel() {

    val articleObservable = ObservableField<ArticleModel>()
    val dateObservable = ObservableField<String>()

    val onBackEvent = SingleLiveEvent<Boolean>()

    val onBackClicked: () -> Unit = { onBackEvent.value = true }

    fun init(bundle: Bundle?) {
        bundle?.let {
            val item = it.getParcelable("data") as ArticleModel?
            item?.run {
                articleObservable.set(this)
                dateObservable.set(Utilities.formatDate(publishedAt))
            }
        }
    }

    fun openWebsite(view: View) {
        IntentClass.goToLink(view.context, articleObservable.get()?.url)
    }
}