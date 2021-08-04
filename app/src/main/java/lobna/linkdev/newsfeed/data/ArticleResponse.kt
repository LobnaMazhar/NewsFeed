package lobna.linkdev.newsfeed.data

import android.os.Parcel
import android.os.Parcelable

data class ArticleResponse(
    val articles: List<ArticleModel>
)

data class ArticleModel(
    val author: String,
    val title: String,
    val description: String,
    val urlToImage: String,
    val publishedAt: String,
    val url: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(author)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(urlToImage)
        parcel.writeString(publishedAt)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ArticleModel> {
        override fun createFromParcel(parcel: Parcel): ArticleModel {
            return ArticleModel(parcel)
        }

        override fun newArray(size: Int): Array<ArticleModel?> {
            return arrayOfNulls(size)
        }
    }
}