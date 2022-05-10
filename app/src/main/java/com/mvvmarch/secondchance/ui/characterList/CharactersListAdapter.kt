package com.mvvmarch.secondchance.ui.characterList

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mvvmarch.secondchance.R
import com.mvvmarch.secondchance.databinding.CardItemBinding
import com.mvvmarch.secondchance.model.entities.CharactersItem

class CharactersListAdapter () : RecyclerView.Adapter<CharacterViewHolder>() {


    private val items = ArrayList<CharactersItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: ArrayList<CharactersItem>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding: CardItemBinding = CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) = holder.bind(items[position])
}

class CharacterViewHolder(private val itemBinding: CardItemBinding) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {

    private lateinit var character: CharactersItem


    fun bind(item: CharactersItem) {
        this.character = item
        itemBinding.name.text = item.Name
        Glide.with(itemBinding.root)
            .load(item.PicUrl)
            .placeholder(R.drawable.futur)
            .error(R.drawable.futur)
            .fallback(R.drawable.futur)
            .into(itemBinding.photo)
    }

    override fun onClick(v: View?) {

    }
}
