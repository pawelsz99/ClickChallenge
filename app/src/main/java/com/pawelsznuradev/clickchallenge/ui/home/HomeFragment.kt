package com.pawelsznuradev.clickchallenge.ui.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.pawelsznuradev.clickchallenge.R
import com.pawelsznuradev.clickchallenge.databinding.HomeFragmentBinding
import kotlin.system.exitProcess


class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: HomeFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.home_fragment, container, false)

        binding.homePlayButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_playFragment)
        }

        binding.homeMoreButton.setOnClickListener {
            //TODO
        }

        binding.homeQuitButton.setOnClickListener {
            exitProcess(0)
        }

        return binding.root
    }
}
