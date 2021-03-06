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

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val timerViewModel: TimerViewModel by viewModels()
        setContent {
            MyTheme {
                MyApp(timerViewModel)
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp(timerViewModel: TimerViewModel) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            Row {
                val remainingTime3: Int by timerViewModel.digit3.observeAsState(0)
                val remainingTime2: Int by timerViewModel.digit2.observeAsState(0)
                val remainingTime1: Int by timerViewModel.digit1.observeAsState(0)
                val remainingTime0: Int by timerViewModel.digit0.observeAsState(0)
                Digit(transition(remainingTime3.toFigure()))
                Digit(transition(remainingTime2.toFigure()))
                Text(text = ":", style = MaterialTheme.typography.h2)
                Digit(transition(remainingTime1.toFigure()))
                Digit(transition(remainingTime0.toFigure()))
            }
            val isRunning: Boolean by timerViewModel.isRunning.observeAsState(false)
            if (isRunning) {
                FloatingActionButton(onClick = { timerViewModel.pauseTimer() }) { Icon(imageVector = Icons.Filled.Pause, contentDescription = "Pause") }
            } else {
                FloatingActionButton(onClick = { timerViewModel.startTimer() }) { Icon(imageVector = Icons.Filled.PlayArrow, contentDescription = "Start") }
            }
        }
    }
}

@Composable
fun transition(newFigure: Figure): Array<FloatArray> {
    val transitionPoints = Array(newFigure.controlPoints.size) { FloatArray(2) }

    val transition = updateTransition(targetState = newFigure)
    for (i in newFigure.controlPoints.indices) {
        transitionPoints[i][0] = transition.animateFloat { figure -> figure.controlPoints[i][0] }.value
        transitionPoints[i][1] = transition.animateFloat { figure -> figure.controlPoints[i][1] }.value
    }
    return transitionPoints
}

@Composable
fun Digit(controlPoints: Array<FloatArray>) {
    val color = MaterialTheme.colors.onSurface
    Canvas(
        modifier = Modifier
            .height(130.dp)
            .width(80.dp)
    ) {
        val width = size.width
        val height = size.height
        val minDimen = if (height > width) width else height
        val path = Path()

        path.moveTo(minDimen * controlPoints[0][0], minDimen * controlPoints[0][1])

        var i = 1
        while (i < controlPoints.size) {
            path.cubicTo(
                minDimen * controlPoints[i][0], minDimen * controlPoints[i][1],
                minDimen * controlPoints[i + 1][0], minDimen * controlPoints[i + 1][1],
                minDimen * controlPoints[i + 2][0], minDimen * controlPoints[i + 2][1]
            )
            i += 3
        }

        drawPath(path, color = color, style = Stroke(width = 9.dp.toPx(), join = StrokeJoin.Round, cap = StrokeCap.Round))
    }
}
