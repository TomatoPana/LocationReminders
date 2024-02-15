package com.example.locationreminders

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GridListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: GridLayoutManager
    private lateinit var adapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_list)
        recyclerView = findViewById(R.id.recyclerView)
        initializeRecyclerView()
    }

    private fun initializeRecyclerView() {
        layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager
        adapter = RecyclerViewAdapter(layoutManager)
        recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.change_layout -> {
                if (layoutManager.spanCount == 1) {
                    layoutManager.spanCount = 2
                    item.title = "list"
                } else {
                    layoutManager.spanCount = 1
                    item.title = "grid"
                }
                adapter.notifyItemRangeChanged(0, adapter.itemCount)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}