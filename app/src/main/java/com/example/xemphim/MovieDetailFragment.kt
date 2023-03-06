package com.example.xemphim

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.xemphim.data.DataResoure.listPhim
import com.example.xemphim.model.phim


class MovieDetailFragment : Fragment(R.layout.fragment_movie_detail) {
    fun list(pos:Int):phim{
        return listPhim[pos]
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_movie_detail, container, false)
        var name = view.findViewById<TextView>(R.id.tvNameInfg2)
        var des = view.findViewById<TextView>(R.id.tvDesInfg2)
        var rate = view.findViewById<TextView>(R.id.Rate)
        var rating = view.findViewById<RatingBar>(R.id.ratingBar)
        var listView = view.findViewById<ListView>(R.id.lvTap)
        var i = arguments?.getInt("posision",0) as Int
        name.text = list(i).name
        when(name.text){
            list(i).name ->{
                des.text = list(i).des
                rate.text = list(i).rating.toString()
                rating.rating = list(i).rating.toFloat()
                listView.adapter =
                    activity?.let { ArrayAdapter(it,android.R.layout.simple_list_item_1, list(i).listTap) }
                listView.setOnItemClickListener { adapterView, view, j, l ->
                    Toast.makeText(activity, "bạn chọn tập "+list(i).listTap[j], Toast.LENGTH_LONG).show()
                }
            }

        }
        return view
    }
}