package com.udacity.shoestore.screens.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLogingBinding

/**
 * This is the Login Fragment, two types of cases, the user login with a existing account
 * or login with a existing one
 */

class LogingFragment : Fragment() {

    private lateinit var binding: FragmentLogingBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate( inflater, R.layout.fragment_loging, container, false)

        return binding.root
    }


}