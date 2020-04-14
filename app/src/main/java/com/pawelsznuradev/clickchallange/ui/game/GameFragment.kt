package com.pawelsznuradev.clickchallange.ui.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pawelsznuradev.clickchallange.R
import com.pawelsznuradev.clickchallange.databinding.GameFragmentBinding

@Suppress("DEPRECATION")
class GameFragment : Fragment() {

    //private var currentScore = 0

    private lateinit var viewModel: GameViewModel

    private lateinit var binding: GameFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val binding: GameFragmentBinding = DataBindingUtil.inflate(
//            inflater, R.layout.game_fragment, container, false)
//
//        binding.gameButton.setOnClickListener {
//            click()
//            binding.gameCurrentScore.text = currentScore.toString()
//        }

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(inflater,R.layout.game_fragment,
            container,false)

        // Get the viewmodel
        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)

        // Set the viewmodel for databinding - this allows the bound layout access to all of the
        // data in the VieWModel
        binding.gameViewModel = viewModel

        // Specify the current activity as the lifecycle owner of the binding. This is used so that
        // the binding can observe LiveData updates
        binding.lifecycleOwner = this

        // Sets up event listening to navigate the player when the game is finished
        viewModel.eventGameFinish.observe(this, Observer{isFinished ->
            if (isFinished){
                val currentScore = viewModel.score.value ?:0
                val action = GameFragmentDirections.action
            }


        })




        return binding.root
    }

//    private fun click(){
//        currentScore++
//    }



}