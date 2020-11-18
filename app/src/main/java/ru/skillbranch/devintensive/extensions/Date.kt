package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.absoluteValue
import kotlin.math.roundToLong

fun Date.format(format: String = "HH:mm:ss dd.MM.yy"): String {
    val locale = Locale("ru")
    return SimpleDateFormat(format, locale).format(this)
}

fun Date.add(value: Int, unit: TimeUnits): Date {
    when (unit) {
        TimeUnits.SECOND -> this.seconds += value
        TimeUnits.MINUTE -> this.minutes += value
        TimeUnits.HOUR -> this.hours += value
        TimeUnits.DAY -> this.date += value
    }
    return this
}

fun Date.humanizeDiff(): String {
    val ms = this.time - System.currentTimeMillis()
    return if (ms > 0) humanizeAfter(ms) else humanizeBefore(
        -ms
    )
}

private fun humanizeAfter(ms: Long): String {
    val sec = ms / 1000.0
    if (sec < 1) return "сейчас"
    if (sec < 45) return "через несколько секунд"
    if (sec < 75) return "через минуту"
    val min = sec / 60.0
    if (min < 45) return humanizeAfter(
        min.roundToLong(),
        "минуту",
        "минуты",
        "минут"
    )
    if (min < 75) return "через час"
    val hour = min / 60.0
    if (hour < 22) return humanizeAfter(
        hour.roundToLong(),
        "час",
        "часа",
        "часов"
    )
    if (hour < 26) return "через день"
    val day = hour / 24.0
    if (day < 360) return humanizeAfter(day.roundToLong(), "день", "дня", "дней")
    return "более чем через год"
}

private fun humanizeBefore(ms: Long): String {
    val sec = ms / 1000.0
    if (sec < 1) return "только что"
    if (sec < 45) return "несколько секунд назад"
    if (sec < 75) return "минуту назад"
    val min = sec / 60.0
    if (min < 45) return humanizeBefore(
        min.roundToLong(),
        "минуту",
        "минуты",
        "минут"
    )
    if (min < 75) return "час назад"
    val hour = min / 60.0
    if (hour < 22) return humanizeBefore(
        hour.roundToLong(),
        "час",
        "часа",
        "часов"
    )
    if (hour < 26) return "день назад"
    val day = hour / 24.0
    if (day < 360) return humanizeBefore(
        day.roundToLong(),
        "день",
        "дня",
        "дней"
    )
    return "более года назад"
}

private fun humanizeAfter(number: Long, singular: String, dual: String, plural: String): String {
    val unit = when (number.rem(10)) {
        1L -> singular
        in 2L..4L -> dual
        else -> plural
    }
    return "через $number $unit"
}

private fun humanizeBefore(number: Long, singular: String, dual: String, plural: String): String {
    val unit = when (number.rem(10)) {
        1L -> singular
        in 2L..4L -> dual
        else -> plural
    }
    return "$number $unit назад"
}

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