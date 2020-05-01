package com.pawelsznuradev.clickchallenge.ui.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.pawelsznuradev.clickchallenge.R
import com.pawelsznuradev.clickchallenge.databinding.GameFragmentBinding



@Suppress("DEPRECATION")
class GameFragment : Fragment() {

    private lateinit var viewModel: GameViewModel
    private lateinit var viewModelFactory: GameViewModelFactory

    private lateinit var binding: GameFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(inflater, R.layout.game_fragment,
            container,false)

        val gameFragmentArgs by navArgs<GameFragmentArgs>()
        val x = gameFragmentArgs.gamemode

        viewModelFactory = GameViewModelFactory(x)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(GameViewModel::class.java)


        // Set the viewmodel for databinding - this allows the bound layout access to all of the
        // data in the VieWModel
        binding.gameViewModel = viewModel

        // Specify the current activity as the lifecycle owner of the binding. This is used so that
        // the binding can observe LiveData updates
        binding.lifecycleOwner = this


        // Sets up event listening to navigate the player when the game is finished
        viewModel.eventGameFinish.observe(viewLifecycleOwner, Observer{isFinished ->
            if (isFinished){
                val currentScore = viewModel.score.value ?:0
                val action = GameFragmentDirections.actionGameFragmentToAfterFragment(currentScore, x)
                findNavController().navigate(action)
                viewModel.onGameFinishComplete()
            }
        })

        return binding.root
    }



}