package me.ijauradunbi.slempit.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.ijauradunbi.slempit.R


class PengeluaranFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_pengeluaran, container, false)
    }

    companion object {
        fun newInstance(): PengeluaranFragment {
            return PengeluaranFragment()
        }
    }
}
