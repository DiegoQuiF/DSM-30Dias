package com.example.diasmes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class Dia (
    val nroDia: String,
    @StringRes val mensajeStringId: Int,
    @StringRes val descStringId: Int,
    @DrawableRes val imageResourceId: Int
)