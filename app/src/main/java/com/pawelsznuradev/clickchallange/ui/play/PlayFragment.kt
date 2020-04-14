package com.pawelsznuradev.clickchallange.ui.play

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.pawelsznuradev.clickchallange.R
import com.pawelsznuradev.clickchallange.databinding.PlayFragmentBinding

class PlayFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: PlayFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.play_fragment, container, false)

        binding.playGamemode1.setOnClickListener {
            findNavController().navigate(R.id.action_playFragment_to_gameFragment)
        }

        binding.playGamemode2.setOnClickListener {
            findNavController().navigate(R.id.action_playFragment_to_gameFragment)
        }

        binding.playGamemode3.setOnClickListener {
            findNavController().navigate(R.id.action_playFragment_to_gameFragment)
        }


        return binding.root
    }


}