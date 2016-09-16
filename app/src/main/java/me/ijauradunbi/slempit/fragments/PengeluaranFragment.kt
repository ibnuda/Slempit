package me.ijauradunbi.slempit.fragments

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import com.github.florent37.carpaccio.Carpaccio
import com.github.florent37.carpaccio.controllers.adapter.Holder
import com.github.florent37.carpaccio.controllers.adapter.OnItemClickListener
import me.ijauradunbi.slempit.R
import java.util.*


class PengeluaranFragment : Fragment() {

    private var contentItems = ArrayList<Any>()
    private var carpaccio: Carpaccio? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_pengeluaran, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        carpaccio = view!!.findViewById(R.id.carpaccio) as Carpaccio

        for (i in 0..ITEM_COUNT - 1) {
            contentItems.add(Any())
        }

        carpaccio!!.mapList("card", contentItems)
        carpaccio!!.onItemClick("card", object : OnItemClickListener<Any> {
            override fun onItemClick(item: Any?, position: Int, holder: Holder?) = Toast.makeText(activity, "position" + position, Toast.LENGTH_LONG).show()
            override fun isClickable(item: Any?, position: Int, holder: Holder?): Boolean = true
        })
    }

    companion object {
        var ITEM_COUNT = 10
        fun newInstance(): PengeluaranFragment {
            return PengeluaranFragment()
        }
    }
}
