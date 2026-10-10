package com.example.tugas3

import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.compose.ui.text.font.FontFamily

data class ProfileData(
    @StringRes val name: Int,
    @StringRes val phone: Int? = null,
    @StringRes val address: Int,
    @ColorRes val backgroundColor: Int,
    @ColorRes val nameColor: Int,
    @ColorRes val phoneColor: Int,
    @ColorRes val addressColor: Int,
    val nameFont: FontFamily = FontFamily.Default
)