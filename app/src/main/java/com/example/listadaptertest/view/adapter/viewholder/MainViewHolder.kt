package com.example.listadaptertest.view.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.listadaptertest.databinding.CardListUiBinding
import com.example.listadaptertest.model.data.CardModel
import com.example.listadaptertest.viewmodel.CardViewModel

class MainViewHolder (val binding : CardListUiBinding, var viewModel : CardViewModel) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(data: CardModel) = with(binding) {
        binding.cardModelData = data
        button.setOnClickListener{
            viewModel.deleteData(data.num)
        }
    }
}