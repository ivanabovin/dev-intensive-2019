package ru.skillbranch.devintensive.unitls

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.skillbranch.devintensive.utils.TimeUnits.*

class TimeUnitsTest {

    @Test
    fun plural() {
        assertEquals("1 секунду", SECOND.plural(1))
        assertEquals("4 минуты", MINUTE.plural(4))
        assertEquals("19 часов", HOUR.plural(19))
        assertEquals("222 дня", DAY.plural(222))
    }
}