package com.example.labb12

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        configureLayoutManager()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        configureLayoutManager()
    }

    private fun configureLayoutManager() {
        val orientation = resources.configuration.orientation
        recyclerView.layoutManager = if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Usamos 2 columnas en orientación horizontal
            GridLayoutManager(this, 2)
        } else {
            LinearLayoutManager(this)
        }
    }
}
