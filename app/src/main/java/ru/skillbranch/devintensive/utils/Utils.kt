package ru.skillbranch.devintensive.utils

import ru.skillbranch.devintensive.extensions.replace
import ru.skillbranch.devintensive.extensions.trimToNull
import java.util.Locale

object Utils {
    fun parseFullName(fullName: String): Pair<String?, String?> {
        val names = fullName.split(" ")
        return name(names, 0) to name(names, 1)
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        val initials = sequenceOf(firstName, lastName)
            .map { it.trimToNull() }
            .filterNotNull()
            .joinToString(separator = "") { it.take(1).toUpperCase(Locale("ru")) }
        return initials.trimToNull()
    }

    fun transliteration(payload: String, divider: String = " "): String {
        return payload.replace(" ", divider).replace { transliterate(it) }
    }

    private fun name(names: List<String>, index: Int): String? {
        if (names.size <= index) return null
        return names[index].trimToNull()
    }

    private fun transliterate(c: Char): String {
        return when (c) {
            'а' -> "a"
            'б' -> "b"
            'в' -> "v"
            'г' -> "g"
            'д' -> "d"
            'е' -> "e"
            'ё' -> "e"
            'ж' -> "zh"
            'з' -> "z"
            'и' -> "i"
            'й' -> "i"
            'к' -> "k"
            'л' -> "l"
            'м' -> "m"
            'н' -> "n"
            'о' -> "o"
            'п' -> "p"
            'р' -> "r"
            'с' -> "s"
            'т' -> "t"
            'у' -> "u"
            'ф' -> "f"
            'х' -> "h"
            'ц' -> "c"
            'ч' -> "ch"
            'ш' -> "sh"
            'щ' -> "sh'"
            'ъ' -> ""
            'ы' -> "i"
            'ь' -> ""
            'э' -> "e"
            'ю' -> "yu"
            'я' -> "ya"
            'А' -> "A"
            'Б' -> "B"
            'В' -> "V"
            'Г' -> "G"
            'Д' -> "D"
            'Е' -> "E"
            'Ё' -> "E"
            'Ж' -> "Zh"
            'З' -> "Z"
            'И' -> "I"
            'Й' -> "I"
            'К' -> "K"
            'Л' -> "L"
            'М' -> "M"
            'Н' -> "N"
            'О' -> "O"
            'П' -> "P"
            'Р' -> "R"
            'С' -> "S"
            'Т' -> "T"
            'У' -> "U"
            'Ф' -> "F"
            'Х' -> "H"
            'Ц' -> "C"
            'Ч' -> "Ch"
            'Ш' -> "Sh"
            'Щ' -> "Sh'"
            'Ъ' -> ""
            'Ы' -> "I"
            'Ь' -> ""
            'Э' -> "E"
            'Ю' -> "Yu"
            'Я' -> "Ya"
            else -> c.toString()
        }
    }
}
