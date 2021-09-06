package com.example.tita.ui.fragment.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.tita.R
import com.example.tita.databinding.FragmentLoginBinding
import com.example.tita.databinding.FragmentNoticeBinding

class NoticeFragment : Fragment() {

    lateinit var binding:FragmentNoticeBinding

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View {
         binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_notice, container, false)

        binding.fragment=this
        return binding.root

    }
}