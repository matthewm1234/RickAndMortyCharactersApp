package com.example.rickandmortycharacters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortycharacters.api.Character
import com.example.rickandmortycharacters.databinding.CharacterListItemBinding


class MainRecyclerAdapter(private val context:Context, private val charaters :List<Character>) : RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder>() {

    inner class MainViewHolder (private var binding: CharacterListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindItem(character:Character) {
            binding.name.text = character.characterName
            binding.speciesValue.text = character.characterSpecie
            binding.statusValue.text = character.characterStatus
            Glide.with(context)
                .load(character.characterImage)
                .into(binding.characterImage)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
            return MainViewHolder(
                CharacterListItemBinding.inflate(LayoutInflater.from(parent.context),
                    parent,
                false)
            )
    }

    override fun getItemCount(): Int {
        return charaters.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        return holder.bindItem(charaters.get(position))
    }
}