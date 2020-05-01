package com.pawelsznuradev.clickchallenge.ui.play

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.pawelsznuradev.clickchallenge.R
import com.pawelsznuradev.clickchallenge.databinding.PlayFragmentBinding

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
            val gameMode = 1
            val action = PlayFragmentDirections.actionPlayFragmentToGameFragment(gameMode)
            findNavController().navigate(action)
        }

        binding.playGamemode2.setOnClickListener {
            val gameMode = 2
            val action = PlayFragmentDirections.actionPlayFragmentToGameFragment(gameMode)
            findNavController().navigate(action)
        }

        binding.playGamemode3.setOnClickListener {
            val gameMode = 3
            val action = PlayFragmentDirections.actionPlayFragmentToGameFragment(gameMode)
            findNavController().navigate(action)
        }


        return binding.root
    }


}