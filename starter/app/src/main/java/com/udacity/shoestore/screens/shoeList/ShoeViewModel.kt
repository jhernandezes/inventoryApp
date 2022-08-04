package com.udacity.shoestore.screens.shoeList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    private var list_shoe = ArrayList<Shoe>()


    private var _shoe_list = MutableLiveData<ArrayList<Shoe>>()
    val shoe_list: LiveData<ArrayList<Shoe>>
        get() = _shoe_list


    fun addShoeModel(shoeModel : Shoe){
        list_shoe.add(shoeModel)
        _shoe_list.value = list_shoe

    }

}