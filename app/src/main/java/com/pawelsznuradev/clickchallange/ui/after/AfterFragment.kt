package com.pawelsznuradev.clickchallange.ui.after

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.pawelsznuradev.clickchallange.R
import com.pawelsznuradev.clickchallange.databinding.AfterFragmentBinding

class AfterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: AfterFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.after_fragment, container, false)

        val afterFragmentArgs by navArgs<AfterFragmentArgs>()

        val finalScore = afterFragmentArgs.score

        binding.afterTextviewScore.text = """Final Score: $finalScore"""

        binding.lifecycleOwner = this

        return binding.root


    }
}