package lobna.linkdev.newsfeed.ui.main

import android.os.Bundle
import android.view.Menu
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import lobna.linkdev.newsfeed.R
import lobna.linkdev.newsfeed.databinding.ActivityMainBinding
import lobna.linkdev.newsfeed.utils.Utilities.showToast

class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        setSupportActionBar(activityMainBinding.contentMain.toolbar)

        activityMainBinding.mvm = mainViewModel

        val toggle = ActionBarDrawerToggle(
            this,
            activityMainBinding.drawerLayout,
            activityMainBinding.contentMain.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        activityMainBinding.drawerLayout.addDrawerListener(toggle)
        toggle.isDrawerIndicatorEnabled = true
        toggle.syncState()

        activityMainBinding.navView.menu.getItem(0).isChecked = true
        activityMainBinding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_explore ->
                    showToast(getString(R.string.explore))
                R.id.nav_live_chat ->
                    showToast(getString(R.string.live_chat))
                R.id.nav_gallery ->
                    showToast(getString(R.string.gallery))
                R.id.nav_wishlist ->
                    showToast(getString(R.string.wishlist))
                R.id.nav_emagazine ->
                    showToast(getString(R.string.emagazine))
            }
            activityMainBinding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
}