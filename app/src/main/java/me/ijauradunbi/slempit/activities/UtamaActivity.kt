package me.ijauradunbi.slempit.activities

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import io.realm.Realm
import io.realm.RealmConfiguration
import me.ijauradunbi.slempit.fragments.PengeluaranFragment
import me.ijauradunbi.slempit.R

class UtamaActivity : AppCompatActivity() {

    internal var toolbar: Toolbar? = null
    internal var navigationViewDrawer: NavigationView? = null
    internal var drawerLayoutDrawer: DrawerLayout? = null
    internal var drawerToggle: ActionBarDrawerToggle? = null

    internal var realm: Realm? = null
    internal var realmConfig: RealmConfiguration? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_utama)

        // Set the toolbar.
        toolbar = findViewById(R.id.toolbar) as Toolbar?
        setSupportActionBar(toolbar)

        // Set the drawer as the navigation thingy.
        navigationViewDrawer = findViewById(R.id.navigation_view) as NavigationView?
        setupDrawerContent(navigationViewDrawer!!)

        // Set the layout
        drawerLayoutDrawer = findViewById(R.id.drawer_layout) as DrawerLayout?
        drawerToggle = setupDrawerToggle()
        drawerLayoutDrawer!!.setDrawerListener(drawerToggle!!)

        navigationViewDrawer!!.menu.getItem(0).isChecked = true

        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.frame_layout_content, PengeluaranFragment()).commit()
    }

    private fun setupDrawerToggle(): ActionBarDrawerToggle? {
        return ActionBarDrawerToggle(this,
                drawerLayoutDrawer,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close)
    }

    private fun setupDrawerContent(navigationViewDrawer: NavigationView) {
        navigationViewDrawer.setNavigationItemSelectedListener { menuItem ->
            selectDrawerItem(menuItem)
            true
        }
    }

    private fun selectDrawerItem(menuItem: MenuItem) {
        var fragment: Fragment? = null
        val fragmentClass: Class<*>

        when (menuItem.itemId) {
            R.id.pengeluaran -> fragmentClass = PengeluaranFragment::class.java
            else -> fragmentClass = PengeluaranFragment::class.java
        }
        try {
            fragment = fragmentClass.newInstance() as Fragment
        } catch (e: Exception) {
            e.printStackTrace()
        }

        val fragmentManager: FragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.frame_layout_content, fragment).commit()

        menuItem.isChecked = true
        title = menuItem.title
        drawerLayoutDrawer!!.closeDrawers()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        drawerToggle!!.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        drawerToggle!!.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return drawerToggle!!.onOptionsItemSelected(item) || super.onOptionsItemSelected(item)
    }
}
