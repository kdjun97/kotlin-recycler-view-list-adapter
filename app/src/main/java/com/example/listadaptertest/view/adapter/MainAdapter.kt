package com.example.listadaptertest.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.listadaptertest.databinding.CardListUiBinding
import com.example.listadaptertest.model.data.CardModel
import com.example.listadaptertest.view.adapter.viewholder.MainViewHolder
import com.example.listadaptertest.viewmodel.CardViewModel

class MainAdapter (private val context : Context, var viewModel : CardViewModel) : ListAdapter<CardModel, MainViewHolder>(diffUtil){
    lateinit var binding : CardListUiBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        binding = CardListUiBinding.inflate(
            LayoutInflater.from(context), parent, false)

        return MainViewHolder(binding, viewModel)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<CardModel>() {
            override fun areItemsTheSame(oldItem: CardModel, newItem: CardModel): Boolean =
                oldItem.num == newItem.num

            override fun areContentsTheSame(oldItem: CardModel, newItem: CardModel): Boolean =
                oldItem == newItem
        }
    }
}