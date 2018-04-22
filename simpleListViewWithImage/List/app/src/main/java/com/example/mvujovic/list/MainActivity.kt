package com.example.mvujovic.list

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listView = findViewById<ListView>(R.id.list);
        listView.adapter = MyCustomAdapter(this);
    }

    private class MyCustomAdapter(context: Context): BaseAdapter() {
        private val mContext: Context

        //private val images = arrayListOf<Int>(R.mipmap.1, R.mipmap.2)
        private val imageIdList = arrayOf<Int>(
                R.drawable.l1,
                R.drawable.l2,
                R.drawable.l3,
                R.drawable.l4,
                R.drawable.l5,
                R.drawable.l6,
                R.drawable.l7,
                R.drawable.l8

        )
        private val names = arrayListOf<String>(
                "The Zebra Swallowtail",
                "Red admiral",
                "Monarch",
                "Blue Morpho Butterfly",
                "Julia",
                "The Mourning Cloak Butterfly",
                "Peacock Butterfly",
                "Tiger Swallowtail Butterfly"
        )

        init {
            mContext = context;
        }

        override fun getCount(): Int {
            return names.size;
        }

        override fun getItem(position: Int): Any {
            return names[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong();
        }

        override fun getView(position: Int, p1: View?, viewGroup: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val rowMain = layoutInflater.inflate(R.layout.row_main, viewGroup, false)

            val imageView = rowMain.findViewById<ImageView>(R.id.imageView);
            imageView.setImageResource(imageIdList[position]);


            val nameTextView = rowMain.findViewById<TextView>(R.id.name)
            nameTextView.text = names.get(position)

            return rowMain
        }
    }
}
