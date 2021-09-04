package com.example.planeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_planet_details.*

class PlanetDetails : AppCompatActivity() {
    private lateinit var obj:PlanetData
    private  var planetimage:Int?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_details)
//        window.decorView.apply {systemUiVisibility=
//            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
//        }
        obj=intent.getParcelableExtra("planet")!!
        planetimage=intent.getIntExtra("planetimg",-1)

        setData(obj, planetimage!!)
        button_info.setOnClickListener{
            val intent=Intent(this,FinalActivity::class.java)
            intent.putExtra("img",planetimage)
            startActivity(intent)
        }
    }
    private fun setData(obj:PlanetData,planetimage:Int){
        title_info.text=obj.title
        galaxy_info.text=obj.galaxy
        distance.text=obj.distance +"m km"
        gravity.text=obj.gravity + "m/ss"
        overview_info.text=obj.overview
        planetimg_info.setImageResource(planetimage)
    }
}