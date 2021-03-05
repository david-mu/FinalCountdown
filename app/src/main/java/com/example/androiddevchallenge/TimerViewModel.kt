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

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Timer
import java.util.TimerTask
import kotlin.concurrent.fixedRateTimer

class TimerViewModel : ViewModel() {
    var remainingTime = 12 * 60

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
    var timer: Timer? = null

    fun startTimer() {
        _isRunning.value = true
        timer = fixedRateTimer(period = 1000, initialDelay = 1000, action = runTimer())
    }

    private fun runTimer(): TimerTask.() -> Unit = {
        remainingTime--
        if (remainingTime < 0) {
            _isRunning.value = false
            cancel()
        } else {
            val d0 = remainingTime % 60 % 10
            if (_digit0.value != d0) {
                _digit0.postValue(d0)
            }
            val d1 = remainingTime % 60 / 10
            if (_digit1.value != d1) {
                _digit1.postValue(d1)
            }
            val d2 = remainingTime / 60 % 10
            if (_digit2.value != d2) {
                _digit2.postValue(d2)
            }
            val d3 = remainingTime / 60 / 10
            if (_digit3.value != d3) {
                _digit3.postValue(d3)
            }
        }
    }

    fun pauseTimer() {
        timer?.cancel()
        _isRunning.value = false
    }
}
