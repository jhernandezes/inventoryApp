package com.udacity.shoestore.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LogingViewModel: ViewModel() {

    private var _user_name = MutableLiveData<String>()
    val user_name: LiveData<String>
        get() = _user_name

    fun onClick(){

    }
}