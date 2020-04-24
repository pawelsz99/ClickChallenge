package com.pawelsznuradev.clickchallange.ui.after

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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

        val x = afterFragmentArgs.gameMode
        val gameMode: String

        gameMode = when(x){
            1 -> "5 seconds"
            2 -> "10 seconds"
            3 -> "30 seconds"
            else -> " "
        }

        binding.afterTextviewScore.text = """Final Score: $finalScore"""
        binding.afterGameMode.text = gameMode


        binding.lifecycleOwner = this

        binding.afterButtonPlayAgain.setOnClickListener {
            findNavController().navigate(R.id.action_afterFragment_to_playFragment)
        }

        binding.afterButtonShare.setOnClickListener {
            onShare(finalScore, gameMode)
        }

        return binding.root


    }



    private fun onShare(finalScore: Int, gameMode: String){
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, getString(R.string.share_text, finalScore, gameMode))
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        try {
            startActivity(shareIntent)
        }   catch (ex: ActivityNotFoundException){
            Toast.makeText(activity, getString(R.string.sharing_not_available),
                Toast.LENGTH_LONG).show()
        }
    }


}