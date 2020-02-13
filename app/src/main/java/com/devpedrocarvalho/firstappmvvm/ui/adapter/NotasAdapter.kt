package com.devpedrocarvalho.firstappmvvm.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devpedrocarvalho.firstappmvvm.R
import com.devpedrocarvalho.firstappmvvm.data.Nota
import kotlinx.android.synthetic.main.item_nota.view.*

class NotasViewHolder(val view: View) : RecyclerView.ViewHolder(view){

    fun bindVieW(item: Nota){
     with(view){
         notaTV.text = item.text
     }
    }
}

class  NotasAdapter(val data: MutableList<Nota> = mutableListOf()): RecyclerView.Adapter<NotasViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotasViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.item_nota, parent, false)
        return NotasViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: NotasViewHolder, position: Int) = holder.bindVieW(data[position])

    fun add(item: Nota){
        data.add(item)
        notifyDataSetChanged()
    }

    fun add(itens: List<Nota>){
        data.clear()
        data.addAll(itens)
        notifyDataSetChanged()
    }

    fun remove(item: Nota){
        data.remove(item)
        notifyDataSetChanged()
    }
}