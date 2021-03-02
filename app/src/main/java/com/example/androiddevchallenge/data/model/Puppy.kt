package com.example.androiddevchallenge.data.model

import androidx.annotation.DrawableRes

data class Puppy(
    @DrawableRes val imgPuppy: Int,
    val title: String,
    val desc: String
)

