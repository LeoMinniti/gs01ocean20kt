package br.com.fiap.gs01ocean20.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.gs01ocean20.R
import br.com.fiap.gs01ocean20.model.ItemModel

class ItensAdapter : RecyclerView.Adapter<ItensAdapter.ItemViewHolder>() {

    private val itens = mutableListOf<ItemModel>()

    fun addItem(newItem: ItemModel) {
        itens.add(newItem)
        notifyDataSetChanged()
    }

    // Criando metodo para delete item
    fun removeItem(item: ItemModel){
        itens.remove(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = itens.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itens[position]
        holder.bind(item)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val textView = view.findViewById<TextView>(R.id.itemTextView)
        val btnDelete = view.findViewById<ImageButton>(R.id.deleteButton)

        fun bind(item: ItemModel) {
            //textView.text = item.praia
            textView.text = "Praia " + item.praia + " da cidade de " + item.cidade + " no estado de " + item.estado

            btnDelete.setOnClickListener(){
                item.onRemove(item)
            }
        }
    }
}

