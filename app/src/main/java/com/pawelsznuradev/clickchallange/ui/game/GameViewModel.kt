package com.pawelsznuradev.clickchallange.ui.game

import android.os.CountDownTimer
import android.text.format.DateUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel



class GameViewModel(gameMode: Int) : ViewModel() {

    private var countDownTime: Long = 0

    companion object{
        // These represent different important times in the game, such as game length.

        // This is when the game is over
        private const val DONE = 0L

        // This is the number of milliseconds in a second
        private const val ONE_SECOND = 1000L

        // This is the total time for gameMode1 - 5s
        private const val COUNTDOWN_TIME1 = 5000L

        // This is the total time for gameMode2 - 10s
        private const val COUNTDOWN_TIME2 = 10000L

        // This is the total time for gameMode1 - 30s
        private const val COUNTDOWN_TIME3 = 30000L

    }

    private val timer: CountDownTimer

    private val _currentTime = MutableLiveData<Long>()
    val currentTime: LiveData<Long>
        get() = _currentTime

    // The String version of the current time
    val currentTimeString = Transformations.map(currentTime) { time ->
        DateUtils.formatElapsedTime(time)
    }

    // Event which triggers the end of the game
    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish: LiveData<Boolean>
        get() = _eventGameFinish

    // The current score
    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    private var mode :Int = 0

    init {
        _score.value = 0

        mode = gameMode

        countDownTime = when (mode){
            1 -> COUNTDOWN_TIME1
            2 -> COUNTDOWN_TIME2
            3 -> COUNTDOWN_TIME3
            else -> 7000L
        }


        timer = object :CountDownTimer(countDownTime, ONE_SECOND){

            override fun onTick(millisUntilFinished: Long) {
                _currentTime.value = (millisUntilFinished / ONE_SECOND)
            }

            override fun onFinish() {
                _currentTime.value = DONE
                _eventGameFinish.value = true
            }

        }

        timer.start()
    }


    /** Methods for buttons presses **/
    fun onGameButtonPressed(){
        _score.value = (_score.value)?.plus(1)
    }


    /** Methods for completed events **/
    fun onGameFinishComplete(){
        _eventGameFinish.value = false
    }

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
    }
}