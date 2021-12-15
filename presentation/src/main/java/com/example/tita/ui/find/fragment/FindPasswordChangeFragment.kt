@file:JvmName("FIndPasswordFragmentKt")

package com.example.tita.ui.find.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tita.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FindPasswordChangeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_find_password_change, container, false)
    }
}