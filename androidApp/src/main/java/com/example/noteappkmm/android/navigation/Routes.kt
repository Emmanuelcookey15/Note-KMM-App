package com.example.noteappkmm.android.navigation

import kotlinx.serialization.Serializable


@Serializable
object ScreenA

@Serializable
data class ScreenB(
    val id: Long?
)