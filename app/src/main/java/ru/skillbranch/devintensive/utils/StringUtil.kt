package ru.skillbranch.devintensive.utils

import kotlin.text.RegexOption.MULTILINE

fun String?.trimToNull(): String? {
    if (this == null) return null
    val trim = this.trim()
    if (trim.isEmpty()) return null
    return trim
}

fun String.truncate(length: Int = 16): String? {
    val trim = this.trim()
    if (trim.length <= length) return trim
    val cut = this.take(length).trimEnd()
    return "$cut..."
}

fun String.replace(f: (c: Char) -> String): String {
    val builder = StringBuilder(this.length)
    this.forEach { builder.append(f(it)) }
    return builder.toString()
}

fun String.stripHtml(): String {
    val tags = Regex("<.*?>", MULTILINE)
    val esc = Regex("&\\w*;", MULTILINE)
    val spaces = Regex("\\s+", MULTILINE)
    return this
        .replace(tags, "")
        .replace(esc, "")
        .replace(spaces, " ")
        .trim()
}