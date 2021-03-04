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

import java.lang.IllegalArgumentException

sealed class Figure(val controlPoints: Array<FloatArray>) {
    val pointsCount = (controlPoints.size + 2) / 3
}

fun Int.toFigure(): Figure {
    return when (this) {
        0 -> Zero
        1 -> One
        2 -> Two
        3 -> Three
        4 -> Four
        5 -> Five
        6 -> Six
        7 -> Seven
        8 -> Eight
        9 -> Nine
        else -> throw IllegalArgumentException()
    }
}

object Zero : Figure(
    arrayOf(
        floatArrayOf(0.24585635359116f, 0.552486187845304f),
        floatArrayOf(0.24585635359116f, 0.331491712707182f),
        floatArrayOf(0.370165745856354f, 0.0994475138121547f),
        floatArrayOf(0.552486187845304f, 0.0994475138121547f),
        floatArrayOf(0.734806629834254f, 0.0994475138121547f),
        floatArrayOf(0.861878453038674f, 0.331491712707182f),
        floatArrayOf(0.861878453038674f, 0.552486187845304f),
        floatArrayOf(0.861878453038674f, 0.773480662983425f),
        floatArrayOf(0.734806629834254f, 0.994475138121547f),
        floatArrayOf(0.552486187845304f, 0.994475138121547f),
        floatArrayOf(0.370165745856354f, 0.994475138121547f),
        floatArrayOf(0.24585635359116f, 0.773480662983425f),
        floatArrayOf(0.24585635359116f, 0.552486187845304f)
    )
)

object One : Figure(
    arrayOf(
        floatArrayOf(0.425414364640884f, 0.113259668508287f),
        floatArrayOf(0.425414364640884f, 0.113259668508287f),
        floatArrayOf(0.577348066298343f, 0.113259668508287f),
        floatArrayOf(0.577348066298343f, 0.113259668508287f),
        floatArrayOf(0.577348066298343f, 0.113259668508287f),
        floatArrayOf(0.577348066298343f, 1f),
        floatArrayOf(0.577348066298343f, 1f),
        floatArrayOf(0.577348066298343f, 1f),
        floatArrayOf(0.577348066298343f, 1f),
        floatArrayOf(0.577348066298343f, 1f),
        floatArrayOf(0.577348066298343f, 1f),
        floatArrayOf(0.577348066298343f, 1f),
        floatArrayOf(0.577348066298343f, 1f)
    )
)
object Two : Figure(
    arrayOf(
        floatArrayOf(0.30939226519337f, 0.331491712707182f),
        floatArrayOf(0.325966850828729f, 0.0110497237569061f),
        floatArrayOf(0.790055248618785f, 0.0220994475138122f),
        floatArrayOf(0.798342541436464f, 0.337016574585635f),
        floatArrayOf(0.798342541436464f, 0.430939226519337f),
        floatArrayOf(0.718232044198895f, 0.541436464088398f),
        floatArrayOf(0.596685082872928f, 0.674033149171271f),
        floatArrayOf(0.519337016574586f, 0.762430939226519f),
        floatArrayOf(0.408839779005525f, 0.856353591160221f),
        floatArrayOf(0.314917127071823f, 0.977900552486188f),
        floatArrayOf(0.314917127071823f, 0.977900552486188f),
        floatArrayOf(0.812154696132597f, 0.977900552486188f),
        floatArrayOf(0.812154696132597f, 0.977900552486188f)
    )
)
object Three : Figure(
    arrayOf(
        floatArrayOf(0.361878453038674f, 0.298342541436464f),
        floatArrayOf(0.348066298342541f, 0.149171270718232f),
        floatArrayOf(0.475138121546961f, 0.0994475138121547f),
        floatArrayOf(0.549723756906077f, 0.0994475138121547f),
        floatArrayOf(0.861878453038674f, 0.0994475138121547f),
        floatArrayOf(0.806629834254144f, 0.530386740331492f),
        floatArrayOf(0.549723756906077f, 0.530386740331492f),
        floatArrayOf(0.87292817679558f, 0.530386740331492f),
        floatArrayOf(0.828729281767956f, 0.994475138121547f),
        floatArrayOf(0.552486187845304f, 0.994475138121547f),
        floatArrayOf(0.298342541436464f, 0.994475138121547f),
        floatArrayOf(0.30939226519337f, 0.828729281767956f),
        floatArrayOf(0.312154696132597f, 0.790055248618785f)
    )
)
object Four : Figure(
    arrayOf(
        floatArrayOf(0.856353591160221f, 0.806629834254144f),
        floatArrayOf(0.856353591160221f, 0.806629834254144f),
        floatArrayOf(0.237569060773481f, 0.806629834254144f),
        floatArrayOf(0.237569060773481f, 0.806629834254144f),
        floatArrayOf(0.237569060773481f, 0.806629834254144f),
        floatArrayOf(0.712707182320442f, 0.138121546961326f),
        floatArrayOf(0.712707182320442f, 0.138121546961326f),
        floatArrayOf(0.712707182320442f, 0.138121546961326f),
        floatArrayOf(0.712707182320442f, 0.806629834254144f),
        floatArrayOf(0.712707182320442f, 0.806629834254144f),
        floatArrayOf(0.712707182320442f, 0.806629834254144f),
        floatArrayOf(0.712707182320442f, 0.988950276243094f),
        floatArrayOf(0.712707182320442f, 0.988950276243094f)
    )
)
object Five : Figure(
    arrayOf(
        floatArrayOf(0.806629834254144f, 0.110497237569061f),
        floatArrayOf(0.502762430939227f, 0.110497237569061f),
        floatArrayOf(0.502762430939227f, 0.110497237569061f),
        floatArrayOf(0.502762430939227f, 0.110497237569061f),
        floatArrayOf(0.397790055248619f, 0.430939226519337f),
        floatArrayOf(0.397790055248619f, 0.430939226519337f),
        floatArrayOf(0.397790055248619f, 0.430939226519337f),
        floatArrayOf(0.535911602209945f, 0.364640883977901f),
        floatArrayOf(0.801104972375691f, 0.469613259668508f),
        floatArrayOf(0.801104972375691f, 0.712707182320442f),
        floatArrayOf(0.773480662983425f, 1.01104972375691f),
        floatArrayOf(0.375690607734807f, 1.0939226519337f),
        floatArrayOf(0.248618784530387f, 0.850828729281768f)
    )
)
object Six : Figure(
    arrayOf(
        floatArrayOf(0.607734806629834f, 0.110497237569061f),
        floatArrayOf(0.607734806629834f, 0.110497237569061f),
        floatArrayOf(0.607734806629834f, 0.110497237569061f),
        floatArrayOf(0.607734806629834f, 0.110497237569061f),
        floatArrayOf(0.392265193370166f, 0.43646408839779f),
        floatArrayOf(0.265193370165746f, 0.50828729281768f),
        floatArrayOf(0.25414364640884f, 0.696132596685083f),
        floatArrayOf(0.287292817679558f, 1.13017127071823f),
        floatArrayOf(0.87292817679558f, 1.06077348066298f),
        floatArrayOf(0.845303867403315f, 0.696132596685083f),
        floatArrayOf(0.806629834254144f, 0.364640883977901f),
        floatArrayOf(0.419889502762431f, 0.353591160220994f),
        floatArrayOf(0.295580110497238f, 0.552486187845304f)
    )
)
object Seven : Figure(
    arrayOf(
        floatArrayOf(0.259668508287293f, 0.116022099447514f),
        floatArrayOf(0.259668508287293f, 0.116022099447514f),
        floatArrayOf(0.87292817679558f, 0.116022099447514f),
        floatArrayOf(0.87292817679558f, 0.116022099447514f),
        floatArrayOf(0.87292817679558f, 0.116022099447514f),
        floatArrayOf(0.7f, 0.422099447513812f),
        floatArrayOf(0.7f, 0.422099447513812f),
        floatArrayOf(0.7f, 0.422099447513812f),
        floatArrayOf(0.477348066298343f, 0.733149171270718f),
        floatArrayOf(0.477348066298343f, 0.733149171270718f),
        floatArrayOf(0.477348066298343f, 0.733149171270718f),
        floatArrayOf(0.25414364640884f, 1f),
        floatArrayOf(0.25414364640884f, 1f)
    )
)
object Eight : Figure(
    arrayOf(
        floatArrayOf(0.558011049723757f, 0.530386740331492f),
        floatArrayOf(0.243093922651934f, 0.524861878453039f),
        floatArrayOf(0.243093922651934f, 0.104972375690608f),
        floatArrayOf(0.558011049723757f, 0.104972375690608f),
        floatArrayOf(0.850828729281768f, 0.104972375690608f),
        floatArrayOf(0.850828729281768f, 0.530386740331492f),
        floatArrayOf(0.558011049723757f, 0.530386740331492f),
        floatArrayOf(0.243093922651934f, 0.530386740331492f),
        floatArrayOf(0.198895027624309f, 0.988950276243094f),
        floatArrayOf(0.558011049723757f, 0.988950276243094f),
        floatArrayOf(0.850828729281768f, 0.988950276243094f),
        floatArrayOf(0.850828729281768f, 0.530386740331492f),
        floatArrayOf(0.558011049723757f, 0.530386740331492f)
    )
)
object Nine : Figure(
    arrayOf(
        floatArrayOf(0.80939226519337f, 0.552486187845304f),
        floatArrayOf(0.685082872928177f, 0.751381215469613f),
        floatArrayOf(0.298342541436464f, 0.740331491712707f),
        floatArrayOf(0.259668508287293f, 0.408839779005525f),
        floatArrayOf(0.232044198895028f, 0.0441988950276243f),
        floatArrayOf(0.81767955801105f, -0.0441988950276243f),
        floatArrayOf(0.850828729281768f, 0.408839779005525f),
        floatArrayOf(0.839779005524862f, 0.596685082872928f),
        floatArrayOf(0.712707182320442f, 0.668508287292818f),
        floatArrayOf(0.497237569060773f, 0.994475138121547f),
        floatArrayOf(0.497237569060773f, 0.994475138121547f),
        floatArrayOf(0.497237569060773f, 0.994475138121547f),
        floatArrayOf(0.497237569060773f, 0.994475138121547f)
    )
)
