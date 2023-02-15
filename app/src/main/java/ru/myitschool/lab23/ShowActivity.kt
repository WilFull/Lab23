package ru.myitschool.lab23

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class RandomValue(val value: String)

class ShowActivity : AppCompatActivity() {

    private lateinit var randomValue: List<RandomValue>
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        val myArray = intent.getDoubleArrayExtra("myArray")
        recyclerView = findViewById(R.id.generated_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter(myArray)
    }
}