package me.ijauradunbi.slempit.activities

import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import me.ijauradunbi.slempit.R

open class DrawerActivity : AppCompatActivity() {

    private var drawer: DrawerLayout? = null
    private var drawerToggle: ActionBarDrawerToggle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()

        drawer = findViewById(R.id.drawer_layout) as DrawerLayout?
        drawerToggle = ActionBarDrawerToggle(this, drawer, 0, 0)
        drawer!!.setDrawerListener(drawerToggle)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowHomeEnabled(true)
            actionBar.setDisplayShowTitleEnabled(true)
            actionBar.setDisplayUseLogoEnabled(false)
            actionBar.setHomeButtonEnabled(true)
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        drawerToggle!!.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return drawerToggle!!.onOptionsItemSelected(item) || super.onOptionsItemSelected(item)
    }
}

