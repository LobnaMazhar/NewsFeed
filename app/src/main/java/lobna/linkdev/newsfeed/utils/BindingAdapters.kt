package lobna.linkdev.newsfeed.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import lobna.linkdev.newsfeed.R

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("loadImage:resource")
    fun loadImage(imageView: ImageView, resource: Int?) {
        resource?.let { imageView.setImageResource(it) }
    }

    @JvmStatic
    @BindingAdapter("loadImage:src")
    fun loadImage(imageView: ImageView, drawable: Drawable?) {
        drawable.let { imageView.setImageDrawable(it) }
    }

    @JvmStatic
    @BindingAdapter(
        value = ["loadImage:url", "loadImage:defaultIcon"],
        requireAll = false
    )
    fun loadImage(
        imageView: ImageView,
        url: String?,
        defaultIcon: Drawable?
    ) {
        val icon = defaultIcon ?: ContextCompat.getDrawable(
            imageView.context,
            R.drawable.placeholder
        )
        if (!url.isNullOrBlank())
            Glide.with(imageView).load(url)
                .placeholder(icon).centerCrop().into(imageView)
        else imageView.setImageDrawable(icon)
    }

    @JvmStatic
    @BindingAdapter("recycler:adapter")
    fun recyclerAdapter(
        recyclerView: RecyclerView,
        adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>
    ) {
        recyclerView.adapter = adapter
    }

    @JvmStatic
    @BindingAdapter("bind:onBackListener")
    fun onBackPressed(toolbar: Toolbar, lambda: () -> Unit) {
        toolbar.setNavigationOnClickListener {
            lambda.invoke()
        }
    }
}
