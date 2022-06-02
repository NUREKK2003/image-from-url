package com.lexmasterteam.recyclerviewapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import androidx.recyclerview.widget.LinearLayoutManager
import com.lexmasterteam.recyclerviewapp2.adapter.ItemCardAdapter
import com.lexmasterteam.recyclerviewapp2.data.ItemCard
import com.lexmasterteam.recyclerviewapp2.databinding.ActivityMainBinding

private lateinit var binding:ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var itemCardList = mutableListOf(
            ItemCard("lorem ipsum","test")
        )
        val adapter = ItemCardAdapter(itemCardList)
        binding.rvItemCard.adapter = adapter
        binding.rvItemCard.layoutManager = LinearLayoutManager(this)

        binding.btCommit.setOnClickListener {
            val imageTitle= binding.etTitle.text.toString()
            val imageURL = binding.etImageURL.text.toString()
            itemCardList.add(ItemCard(imageTitle,imageURL))
            adapter.notifyItemInserted(itemCardList.size-1)

            binding.etTitle.text = Editable.Factory.getInstance().newEditable("")
            binding.etImageURL.text =Editable.Factory.getInstance().newEditable("")

        }
    }
}