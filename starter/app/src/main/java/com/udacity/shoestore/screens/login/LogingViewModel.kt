package com.udacity.shoestore.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LogingViewModel () : ViewModel() {
    private var _user_name = MutableLiveData<String>()
    private var _password = MutableLiveData<String>()

    val user_name: LiveData<String>
        get() = _user_name

    val password: LiveData<String>
        get() = _password

    fun setUserName(s : CharSequence ){
        _user_name.value = s.toString()
    }

    fun setPassword(s : CharSequence ){
        _password.value = s.toString()
    }
}