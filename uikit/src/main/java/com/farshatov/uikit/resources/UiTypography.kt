package com.farshatov.uikit.resources

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Roboto = FontFamily.Default
val UiTypography = Typography(
    body1 = TextStyle(
        fontFamily = Roboto,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.W400
    ),
    body2 = TextStyle(
        fontFamily = Roboto,
        fontSize = 14.sp,
        lineHeight = 22.sp,
        fontWeight = FontWeight.W400
    ),
    h4 = TextStyle(
        fontFamily = Roboto,
        fontSize = 30.sp,
        lineHeight = 28.sp,
        fontWeight = FontWeight.W700
    ),
    h5 = TextStyle(
        fontFamily = Roboto,
        fontSize = 22.sp,
        lineHeight = 25.sp,
        fontWeight = FontWeight.W500
    ),
    h6 = TextStyle(
        fontFamily = Roboto,
        fontSize = 18.sp,
        lineHeight = 28.sp,
        fontWeight = FontWeight.W700
    ),
    subtitle1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.15.sp
    )
)

val TextStyle.medium
    get() = copy(fontWeight = FontWeight.W500)

// Сопоставление стилей с фигмой
enum class UiTextStyle {
    // h1
    H1 {
        override val style: TextStyle
            @Composable get() = UiTypography.h5
    },
    H4_WHITE {
        override val style: TextStyle
            @Composable get() = UiTypography.h4.copy(color = UiColors.WHITE.value)
    },
    H6_WHITE {
        override val style: TextStyle
            @Composable get() = UiTypography.h6.copy(color = UiColors.WHITE.value)
    },

    // Android / Body medium
    BODY_MEDIUM {
        override val style: TextStyle
            @Composable get() = UiTypography.body1.medium
    },

    // title body
    TITLE_BODY {
        override val style: TextStyle
            @Composable get() = UiTypography.body1.copy(lineHeight = 20.sp).medium
    },

    // h1
    H1_WHITE {
        override val style: TextStyle
            @Composable get() = UiTypography.h5.copy(color = UiColors.WHITE.value)
    },

    // TXT-s
    TXT_S_SECOND_TXT {
        override val style: TextStyle
            @Composable get() = UiTypography.body2.copy(color = UiColors.SECOND_TXT.value)
    },

    // TXT-form
    TXT_FORM {
        override val style: TextStyle
            @Composable get() = UiTypography.subtitle1
    },
    BODY2_WHITE_OPACITY60 {
        override val style: TextStyle
            @Composable get() = UiTypography.body2.copy(color = UiColors.WHITE_OPACITY60.value)
    },
    BODY2_WHITE_OPACITY60_SIZE15 {
        override val style: TextStyle
            @Composable get() = UiTypography.body2.copy(
                color = UiColors.WHITE_OPACITY60.value,
                fontSize = 15.sp
            )
    };

    abstract val style: TextStyle
        @Composable get
}
