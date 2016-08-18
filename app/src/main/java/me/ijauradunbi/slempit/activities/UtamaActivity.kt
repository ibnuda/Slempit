package me.ijauradunbi.slempit.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.widget.Toolbar
import com.github.florent37.materialviewpager.MaterialViewPager
import io.realm.Realm
import io.realm.RealmConfiguration
import me.ijauradunbi.slempit.R

class UtamaActivity : DrawerActivity() {

    var materialViewPager: MaterialViewPager? = null
    var toolbar: Toolbar? = null

    internal var realm: Realm? = null
    internal var realmConfiguration: RealmConfiguration? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_utama)

        title = ""

        materialViewPager = findViewById(R.id.material_view_pager) as MaterialViewPager

        toolbar = materialViewPager!!.toolbar

        setSupportActionBar(toolbar!!)

        materialViewPager!!.viewPager.adapter
    }
}
