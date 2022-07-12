package com.example.listadaptertest.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.listadaptertest.model.data.CardModel

class CardViewModel : ViewModel() {
    var count = 0
    val _mutableData = MutableLiveData<MutableList<CardModel>>()
    val mutableData: LiveData<MutableList<CardModel>> get() = _mutableData
    var listInfo = ArrayList<CardModel>()

    fun fetchData() : LiveData<MutableList<CardModel>> {
        return _mutableData
    }

    fun updateView() {
        var value = count.toString()
        listInfo.add(CardModel(num = value, title = value, content = value))
        count++
        _mutableData.value = listInfo
    }

    fun deleteData(num : String) {
        Log.d("[Delete Item]", "$num 아이템을 삭제합니다.")
    }
}