package com.example.recyclerviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviews.MyAdapter
import com.example.recyclerviews.ProgrammingLanguage
import com.example.recyclerviews.R

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var arrayList: ArrayList<ProgrammingLanguage>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = arrayOf(
            R.drawable.c,
            R.drawable.cplusplus,
            R.drawable.css,
            R.drawable.dart,
            R.drawable.java,
            R.drawable.js,
            R.drawable.kotlin,
            R.drawable.python,
            R.drawable.swift)

        heading = arrayOf(
            "icon for assembly programming language",
            "icon for c",
            "icon for c#",
            "icon for c++",
            "icon for css",
            "icon for dart",
            "icon for java",
            "icon for js",
            "icon for Kotlin",
            "icon for Python",
            "icon for Swift"
        )

        newRecyclerView = findViewById(R.id.recyclerview)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        arrayList = arrayListOf<ProgrammingLanguage>()
        getUserData()

    }

    private fun getUserData() {

        for (i in imageId.indices){
            val pl = ProgrammingLanguage(imageId[i], heading[i])
            arrayList.add(pl)
        }

        var adapter = MyAdapter(arrayList)

        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListner(object :MyAdapter.onItemClickListner{
            override fun onitemclick(position: Int) {
                Toast.makeText(this@MainActivity,"you click on item number . $position", Toast.LENGTH_LONG).show()
            }

        })
    }
}