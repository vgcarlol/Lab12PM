package com.example.labb12


import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private val myDataset = arrayOf("Element 1", "Element 2", "Element 3", "Element 4", "Element 5") // Ejemplo de datos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = MyAdapter(myDataset)

        configureLayoutManager()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        configureLayoutManager()
    }

    private fun configureLayoutManager() {
        val isTablet = resources.getBoolean(R.bool.isTablet)
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE || isTablet) {
            // Aumentamos el número de columnas para tablets o paisaje
            recyclerView.layoutManager = GridLayoutManager(this, if (isTablet) 3 else 2)
        } else {
            recyclerView.layoutManager = LinearLayoutManager(this)
        }
    }
}

class MyAdapter(private val dataset: Array<String>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false) as TextView
        return MyViewHolder(textView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = dataset[position]
    }

    override fun getItemCount() = dataset.size
}
