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
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
        Column {
            for (digit in 0..9) {
                Digit(figure = digit.toFigure())
            }
        }
    }
}

@Composable
fun Digit(figure: Figure) {
    val color = MaterialTheme.colors.onSurface
    Canvas(modifier = Modifier.height(100.dp).width(50.dp)) {
        val width = size.width
        val height = size.height
        val minDimen = if (height > width) width else height
        val controlPoints = figure.controlPoints
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

        drawPath(path, color = color, style = Stroke(width = 5.dp.toPx()))
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}