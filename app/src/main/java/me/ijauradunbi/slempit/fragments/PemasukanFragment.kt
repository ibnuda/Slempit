package me.ijauradunbi.slempit.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator

import me.ijauradunbi.slempit.R
import me.ijauradunbi.slempit.adapter.SomethingAdapter
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class PemasukanFragment : Fragment() {
    private var recyclerView: RecyclerView? = null
    private var adapter: RecyclerView.Adapter<*>? = null
    private var contentItems = ArrayList<Any>()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_pemasukan, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view!!.findViewById(R.id.recycler_view) as RecyclerView
        val layoutManager: RecyclerView.LayoutManager
        if (GRID_LAYOUT) {
            layoutManager = GridLayoutManager(activity, 2)
        } else {
            layoutManager = LinearLayoutManager(activity)
        }
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.addItemDecoration(MaterialViewPagerHeaderDecorator())

        adapter = SomethingAdapter(contentItems)
        recyclerView!!.adapter = adapter!!
        run {
            for (i in 0..ITEM_COUNT - 1) {
                contentItems.add(Any())
            }
            adapter!!.notifyDataSetChanged()
        }
    }

    companion object {
        internal val GRID_LAYOUT = false
        private val ITEM_COUNT = 10

        fun newInstance(): PemasukanFragment {
            return PemasukanFragment()
        }
    }

}
