package com.udacity.shoestore.models

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.udacity.shoestore.R

class MyAdapter(private val context: Context, private val arrayList: java.util.ArrayList<Shoe>) : BaseAdapter() {
    private lateinit var shoeName: TextView
    private lateinit var shoeCompany: TextView
    private lateinit var shoeSize: TextView
    private lateinit var shoeDescription: TextView

    override fun getCount(): Int {
        return arrayList.size
    }
    override fun getItem(position: Int): Any {
        return position
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var convertView = convertView
        convertView = LayoutInflater.from(context).inflate(R.layout.row, parent, false)
        shoeName = convertView.findViewById(R.id.shoeName)
        shoeCompany = convertView.findViewById(R.id.shoeCompany)
        shoeSize = convertView.findViewById(R.id.shoeSize)
        shoeDescription = convertView.findViewById(R.id.shoeDescription)
        shoeName.text = " " + arrayList[position].name
        shoeCompany.text = arrayList[position].company
        shoeSize.text = arrayList[position].size
        shoeDescription.text = arrayList[position].description
        return convertView
    }
}