package ru.myitschool.lab23

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(val myArray: Array<RandomValue>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    class ViewHolder(textView: View): RecyclerView.ViewHolder(textView) {
        // val randomResult: TextView = itemView.findViewById(R.id.random_number_result)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val textView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false) as TextView
        return ViewHolder(textView)
    }

    // производит привязку данных к элементам, которые уже отобразились
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.text = myArray[position]
    }

    // возращает размер моего RecyclerView
    override fun getItemCount() = myArray.size
}