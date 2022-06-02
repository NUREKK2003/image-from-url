package com.lexmasterteam.recyclerviewapp2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lexmasterteam.recyclerviewapp2.MainActivity
import com.lexmasterteam.recyclerviewapp2.R
import com.lexmasterteam.recyclerviewapp2.data.ItemCard
import com.lexmasterteam.recyclerviewapp2.databinding.ItemCardBinding

class ItemCardAdapter(
    var itemCardList:List<ItemCard>                                                                         // lista itemów (najczęściej dynamiczna), którą adapter wypełni instancje item cardów
) : RecyclerView.Adapter<ItemCardAdapter.ItemCardViewHolder>() {                                            // klasa dziedziczy po recycer view
    inner class ItemCardViewHolder(val binding: ItemCardBinding):RecyclerView.ViewHolder(binding.root)      //binding z pliku xml wzoru, dzięki temu możemy się później w on bind view holder odwołać do np. tekstu

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCardViewHolder {
        val inflater = LayoutInflater.from(parent.context)                                                  // bierzemy "rozdmuchywacza"
        val binding = ItemCardBinding.inflate(inflater,parent,false)                            //rozdmychanie i podpięcie widoku do binding jak we fragmencie
        return  ItemCardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemCardViewHolder, position: Int) {
        holder.binding.textView2.text = itemCardList[position].imageTitle                                   // ustalamy wartości konkretnej instancji itemCardu
        Glide                                                                                               // ładujemy zdjęcię z url korzystając z biblioteki glide
            .with(holder.binding.imageView.context)                                                         // bierzemy context widoku z dowolnego obiektu który się w nim znajduje
            .load(itemCardList[position].imageUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.binding.imageView)

    }

    override fun getItemCount(): Int {
        return itemCardList.size                                                                            //bierzemy rozmiar listy
    }

}