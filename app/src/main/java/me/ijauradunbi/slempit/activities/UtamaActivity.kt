package me.ijauradunbi.slempit.activities

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.widget.Toolbar
import com.github.florent37.materialviewpager.MaterialViewPager
import io.realm.Realm
import io.realm.RealmConfiguration
import me.ijauradunbi.slempit.R
import me.ijauradunbi.slempit.fragments.PemasukanFragment
import me.ijauradunbi.slempit.fragments.PengeluaranFragment

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
        materialViewPager!!.viewPager.adapter = object: FragmentStatePagerAdapter(supportFragmentManager) {
            override fun getCount(): Int {
                return 1
            }
            override fun getItem(position: Int): Fragment {
                when (position % 4) {
                    0 -> return PemasukanFragment.newInstance()
                    1 -> return PengeluaranFragment.newInstance()
                    else -> return PemasukanFragment.newInstance()
                }
            }

        }
    }
}
