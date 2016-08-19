package me.ijauradunbi.slempit.activities

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.widget.Toolbar
import com.github.florent37.materialviewpager.MaterialViewPager
import com.github.florent37.materialviewpager.header.HeaderDesign
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
                return 2
            }
            override fun getItem(position: Int): Fragment {
                when (position % 4) {
                    0 -> return PemasukanFragment.newInstance()
                    1 -> return PengeluaranFragment.newInstance()
                    else -> return PemasukanFragment.newInstance()
                }
            }
            override fun getPageTitle(position: Int): CharSequence {
                when (position % 4) {
                    0 -> return "Pemasukan"
                    1 -> return "Pengeluaran"
                    else -> return "Pemasukan"
                }
            }
        }

        materialViewPager!!.setMaterialViewPagerListener { page ->
            when (page % 4) {
                0 -> HeaderDesign.fromColorAndUrl(Color.BLUE, "localhost")
                1 -> HeaderDesign.fromColorAndUrl(Color.CYAN, "localhost")
                else -> HeaderDesign.fromColorAndUrl(Color.RED, "localhost")
            }
        }

        materialViewPager!!.viewPager.offscreenPageLimit = materialViewPager!!.viewPager.adapter.count
        materialViewPager!!.pagerTitleStrip.setViewPager(materialViewPager!!.viewPager)


    }
}
