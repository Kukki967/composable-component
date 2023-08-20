package com.groot.composable.ui.dto

import androidx.annotation.DrawableRes

class ComposableCardDto(val label: ComponentCardLabel,@DrawableRes val icon: Int)

enum class ComponentCardLabel {
    LIST,
    FORM,

}