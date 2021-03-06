package com.example.tita.ui.board

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tita.R
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentBoardFreeBinding
import com.example.tita.databinding.FragmentBoardNoticeBinding
import com.example.tita.databinding.FragmentBoardNoticeMenuBinding
import com.example.tita.ui.board.adapter.BoardAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BoardNoticeFragment : UtilityBase.BaseFragment<FragmentBoardNoticeBinding>(R.layout.fragment_board_notice) {

    // TODO: 게시판 만들기 - 공지게시판

    private val viewModel by activityViewModels<BoardViewmodel>()


    override fun FragmentBoardNoticeBinding.onCreateView(){

    }

    override fun FragmentBoardNoticeBinding.onViewCreated(){

        binding.fragment = this@BoardNoticeFragment

        binding.viewmodel = viewmodel

        viewModel.noticeBoard.observe(viewLifecycleOwner,{
            binding.viewmodel = viewModel
        })
    }

}