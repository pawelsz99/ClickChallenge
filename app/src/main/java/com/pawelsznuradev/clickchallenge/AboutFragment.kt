package com.pawelsznuradev.clickchallenge

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.pawelsznuradev.clickchallenge.databinding.FragmentAboutBinding

/**
 * A simple [Fragment] subclass.
 */
class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentAboutBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_about, container, false)

        binding.aboutButton.setOnClickListener {
            findNavController().navigate(R.id.action_aboutFragment_to_homeFragment)
        }

        binding.aboutGithub.setOnClickListener {
          //  val gitLink = Intent(Intent.ACTION_VIEW, Uri.parse(R.string.github_link.toString()))
            val gitLink = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/pawelsz99/ClickChallenge"))

            startActivity(gitLink)
        }

        return binding.root


    }

}
