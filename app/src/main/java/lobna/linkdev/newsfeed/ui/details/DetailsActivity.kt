package lobna.linkdev.newsfeed.ui.details

import android.os.Bundle
import android.view.Menu
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import lobna.linkdev.newsfeed.R
import lobna.linkdev.newsfeed.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private val detailsViewModel by viewModels<DetailsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityDetailsBinding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(activityDetailsBinding.root)

        setSupportActionBar(activityDetailsBinding.toolbar)

        activityDetailsBinding.dvm = detailsViewModel

        detailsViewModel.init(intent.getBundleExtra("data"))

        detailsViewModel.onBackEvent.observe(this, { onBackPressed() })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
}