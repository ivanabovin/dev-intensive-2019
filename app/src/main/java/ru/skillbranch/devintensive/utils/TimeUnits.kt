package ru.skillbranch.devintensive.utils

import kotlin.math.absoluteValue

enum class TimeUnits(
    val singular: String,
    val dual: String,
    val plural: String
) {
    SECOND("секунду", "секунды", "секунд"),
    MINUTE("минуту", "минуты", "минут"),
    HOUR("час", "часа", "часов"),
    DAY("день", "дня", "дней");

    fun plural(value: Int): String {
        val unit = when (value.rem(10).absoluteValue) {
            1 -> singular
            in 2..4 -> dual
            else -> plural
        }
        return "$value $unit"
    }
}