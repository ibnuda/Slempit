package me.ijauradunbi.slempit

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created on 18/08/2016.
 */

class SlempitApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val realmConfiguration = RealmConfiguration.Builder(this).build()
        Realm.setDefaultConfiguration(realmConfiguration)
    }
}
