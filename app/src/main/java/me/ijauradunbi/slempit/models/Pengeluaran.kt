package me.ijauradunbi.slempit.models

import java.util.*

/**
 * Created on 21/08/2016.
 */
open class Pengeluaran {
    open var keluar: Long? = null
    open var siapa: String? = null
    open var total: Long? = null
    open var waktu: Date? = null
}