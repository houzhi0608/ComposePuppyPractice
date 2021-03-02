package com.example.androiddevchallenge.model

import androidx.annotation.DrawableRes

data class Puppy(
    var id: Int,
    val name: String,
    val brithDate: String,
    val sex: Sex,
    val breed: String,
    val location: String,
    @DrawableRes val image: Int,
    val desc: String
) {

}

enum class Sex(val desc: String) {
    MALE("Male"), FEMALE("Female")
}