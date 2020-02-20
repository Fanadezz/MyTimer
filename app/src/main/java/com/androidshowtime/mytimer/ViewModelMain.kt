package com.androidshowtime.mytimer

import android.os.CountDownTimer
import android.text.format.DateUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class ViewModelMain : ViewModel() {


    private val _currentTime = MutableLiveData<Long>()
    val currentTime: LiveData<Long>
        get() = _currentTime


    val currentTimeString  = Transformations.map(currentTime){time -> DateUtils.formatElapsedTime(time)}

    private val timer: CountDownTimer


    init {

        timer = object : CountDownTimer(COUNTDOWN_TIME, TIME_INTERVAL) {
            override fun onFinish() {
                _currentTime.value = DONE
            }

            override fun onTick(millisUntilFinished: Long) {
                _currentTime.value = millisUntilFinished / TIME_INTERVAL

            }


        }


    }


    companion object {


        private const val DONE = 0L
        private const val TIME_INTERVAL = 1000L
        private const val COUNTDOWN_TIME = 15000L
    }

    fun startTimer() {
        timer.start()
    }
}