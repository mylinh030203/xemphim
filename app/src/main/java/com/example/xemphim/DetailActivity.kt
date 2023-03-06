package com.example.xemphim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        var sub2 = MovieDetailFragment()
        var i = intent
        var posision:Int = i.getIntExtra("posision",0)
        var bundle = Bundle()
        bundle.putInt("posision",posision)
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout2,sub2)
            commit()
        }
        sub2.arguments = bundle
    }
}