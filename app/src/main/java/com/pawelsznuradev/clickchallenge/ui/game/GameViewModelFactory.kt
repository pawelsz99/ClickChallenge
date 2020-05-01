package com.pawelsznuradev.clickchallenge.ui.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class GameViewModelFactory(private val gameMode: Int) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameViewModel::class.java)){
            return GameViewModel(gameMode) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}