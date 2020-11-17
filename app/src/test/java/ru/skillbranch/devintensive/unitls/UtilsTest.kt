package ru.skillbranch.devintensive.unitls

import org.junit.Assert.*
import org.junit.Test
import ru.skillbranch.devintensive.utils.Utils

class UtilsTest {

    @Test
    fun toInitials() {
        assertEquals(null, Utils.toInitials(null, null))
        assertEquals(null, Utils.toInitials("", ""))
        assertEquals("J", Utils.toInitials("john", ""))
        assertEquals("JD", Utils.toInitials("john", "doe"))
    }

    @Test
    fun transliteration() {
        assertEquals("Zhenya Stereotipov", Utils.transliteration("Женя Стереотипов"))
        assertEquals("Amazing_Petr", Utils.transliteration("Amazing Петр", "_"))
    }
}