package lobna.linkdev.newsfeed.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import lobna.linkdev.newsfeed.R
import lobna.linkdev.newsfeed.data.ArticleModel
import lobna.linkdev.newsfeed.databinding.ItemArticleBinding

class ArticlesAdapter(
    private val items: ArrayList<ArticleModel>, val articleInterface: ArticleInterface
) :
    RecyclerView.Adapter<ArticlesAdapter.ArticleViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArticleViewHolder {
        val itemArticleBinding: ItemArticleBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_article,
            parent,
            false
        )
        return ArticleViewHolder(itemArticleBinding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ArticleViewHolder(var itemArticleBinding: ItemArticleBinding) :
        RecyclerView.ViewHolder(itemArticleBinding.root) {

        fun bind(item: ArticleModel) {
            itemArticleBinding.aivm = ArticlesItemViewModel(item, articleInterface)
        }
    }
}