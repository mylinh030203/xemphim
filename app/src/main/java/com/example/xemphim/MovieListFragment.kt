package com.example.xemphim

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xemphim.data.DataResoure.listPhim
import com.example.xemphim.model.phim


class MovieListFragment : Fragment(R.layout.fragment_movie_list) {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_movie_list,container,false)
        var recyclerView :RecyclerView = view.findViewById(R.id.rvPhim)
        var list = mutableListOf<phim>()
           listPhim.forEach{
               list.add(it)
           }
        var adapter = rvAdapter(list,object : rvInterface{
            override fun Onclick(position: Int) {
                var intent :Intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra("posision",position)
                startActivity(intent)
            }
        })
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        return view
    }

}