package me.ijauradunbi.slempit.models

import io.realm.RealmObject
import java.util.*

/**
 * Created on 21/08/2016.
 */
open class Pengeluaran : RealmObject() {
    open var keluar: Long? = null
    open var siapa: String? = null
    open var total: Long? = null
    open var waktu: Date? = null
}