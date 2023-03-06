package com.example.xemphim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var sub1 = MovieListFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.framelayout,sub1)
            commit()
        }
    }
}