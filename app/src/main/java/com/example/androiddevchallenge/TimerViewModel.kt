/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TimerViewModel : ViewModel() {
    private var _remainingTime = MutableLiveData<Int>()
    private val _mediator: MediatorLiveData<Int> = MediatorLiveData<Int>()

    private val _digit0 = MutableLiveData<Int>()
    private val _digit1 = MutableLiveData<Int>()
    private val _digit2 = MutableLiveData<Int>()
    private val _digit3 = MutableLiveData<Int>()
    private val _isRunning = MutableLiveData<Boolean>()

    val digit0: LiveData<Int> get() = _digit0
    val digit1: LiveData<Int> get() = _digit1
    val digit2: LiveData<Int> get() = _digit2
    val digit3: LiveData<Int> get() = _digit3
    val isRunning: LiveData<Boolean> get() = _isRunning

    private var _countDownTimer: CountDownTimer? = null

    private val initialRemainingTime = 15 * 60

    fun startTimer() {
        _isRunning.value = true
        _countDownTimer = object : CountDownTimer(1000L.times(_remainingTime.value!! + 1), 1000L) {
            override fun onTick(millisUntilFinished: Long) {
                _remainingTime.postValue((millisUntilFinished / 1000).toInt())
            }

            override fun onFinish() {
                _isRunning.value = false
            }
        }
        checkNotNull(_countDownTimer).start()
    }

    fun pauseTimer() {
        _isRunning.value = false
        _countDownTimer?.cancel()
    }

    init {
        _mediator.observeForever {}
        _mediator.addSource(_remainingTime) {
            val d0 = it % 60 % 10
            if (_digit0.value != d0) {
                _digit0.value = d0
            }
            val d1 = it % 60 / 10
            if (_digit1.value != d1) {
                _digit1.value = d1
            }
            val d2 = it / 60 % 10
            if (_digit2.value != d2) {
                _digit2.value = d2
            }
            val d3 = it / 60 / 10
            if (_digit3.value != d3) {
                _digit3.value = d3
            }
        }
        _remainingTime.value = initialRemainingTime
    }
}
