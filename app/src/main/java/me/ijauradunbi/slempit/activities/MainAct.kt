package me.ijauradunbi.slempit.activities

import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import org.jetbrains.anko.AnkoLogger

class MainAct : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, AnkoLogger {

    lateinit var ndhas: Toolbar
    lateinit var laci: DrawerLayout

    override fun onNavigationItemSelected(item: MenuItem?): Boolean {
        return true
    }
}
