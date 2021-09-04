package com.example.planeto

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view.view.*

class Adapter(var planet: List<PlanetData>) : RecyclerView.Adapter<Adapter.myViewHolder>() {

    class myViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var title = view.title
        var planetimg = view.planetimg
        var galaxy = view.galaxy
        var distance = view.distance
        var gravity = view.gravity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.view, parent, false)
        return myViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        var dummyimg: Int? = null
        holder.itemView.setOnClickListener {
            val intent=Intent(holder.itemView.context,PlanetDetails::class.java)
            intent.putExtra("planet",planet[position])
            intent.putExtra("planetimg",dummyimg)
            holder.itemView.context.startActivity(intent)
        }
        holder.title.text = planet[position].title
        holder.galaxy.text = planet[position].galaxy
        holder.distance.text = planet[position].distance
        holder.gravity.text = planet[position].gravity
        when (planet[position].title!!.toLowerCase()) {
            "earth" -> dummyimg = R.drawable.ic_earth
            "jupiter" -> dummyimg = R.drawable.ic_jupiter
            "mars" -> dummyimg = R.drawable.ic_mars
            "mercury" -> dummyimg = R.drawable.ic_mercury
            "moon" -> dummyimg = R.drawable.ic_moon
            "neptune" -> dummyimg = R.drawable.ic_neptune
            "saturn" -> dummyimg = R.drawable.ic_saturn
            "sun" -> dummyimg = R.drawable.ic_sun
            "uranus" -> dummyimg = R.drawable.ic_uranus
            "venus" -> dummyimg = R.drawable.ic_venus
        }
        holder.planetimg.setImageResource(dummyimg!!)
    }

    override fun getItemCount(): Int {
        return planet.size
    }
}
