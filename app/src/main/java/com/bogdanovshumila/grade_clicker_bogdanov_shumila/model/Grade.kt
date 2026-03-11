package com.bogdanovshumila.grade_clicker_bogdanov_shumila.model

import androidx.annotation.DrawableRes

data class Grade(
    @DrawableRes val imageId: Int,
    val pointsPerClickval : Int,
    val threshold: Int
)