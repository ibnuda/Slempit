package me.ijauradunbi.slempit.models

import android.text.format.DateUtils
import io.realm.RealmObject
import java.util.*

/**
 * Created on 18/08/2016.
 */

open class Pemasukan : RealmObject() {
    open var total: Long? = null
}
