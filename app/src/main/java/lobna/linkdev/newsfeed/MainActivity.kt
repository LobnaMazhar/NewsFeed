package lobna.linkdev.newsfeed

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.google.android.material.navigation.NavigationView
import lobna.linkdev.newsfeed.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        setSupportActionBar(activityMainBinding.contentMain.toolbar)

        val drawerLayout: DrawerLayout = activityMainBinding.drawerLayout
        val navView: NavigationView = activityMainBinding.navView
        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_explore ->
                    Toast.makeText(this, getString(R.string.explore), Toast.LENGTH_SHORT).show()
                R.id.nav_live_chat ->
                    Toast.makeText(this, getString(R.string.live_chat), Toast.LENGTH_SHORT).show()
                R.id.nav_gallery ->
                    Toast.makeText(this, getString(R.string.gallery), Toast.LENGTH_SHORT).show()
                R.id.nav_wishlist ->
                    Toast.makeText(this, getString(R.string.wishlist), Toast.LENGTH_SHORT).show()
                R.id.nav_emagazine ->
                    Toast.makeText(this, getString(R.string.emagazine), Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
}