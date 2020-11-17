package ru.skillbranch.devintensive.unitls

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.skillbranch.devintensive.utils.TimeUnits
import ru.skillbranch.devintensive.utils.add
import ru.skillbranch.devintensive.utils.humanizeDiff
import java.util.*

class DateUtilTest {

    @Test
    fun humanizeDiff() {
        // before
        assertEquals("только что", Date().humanizeDiff())
        assertEquals("минуту назад", Date().add(-1, TimeUnits.MINUTE).humanizeDiff())
        assertEquals("2 часа назад", Date().add(-2, TimeUnits.HOUR).humanizeDiff())
        assertEquals("55 дней назад", Date().add(-55, TimeUnits.DAY).humanizeDiff())
        assertEquals("более года назад", Date().add(-400, TimeUnits.DAY).humanizeDiff())
        // after
        assertEquals("сейчас", Date().apply { this.time += 100 }.humanizeDiff())
        assertEquals("через 2 минуты", Date().add(2, TimeUnits.MINUTE).humanizeDiff())
        assertEquals("через час", Date().add(1, TimeUnits.HOUR).humanizeDiff())
        assertEquals("через 7 дней", Date().add(7, TimeUnits.DAY).humanizeDiff())
        assertEquals("более чем через год", Date().add(400, TimeUnits.DAY).humanizeDiff())
    }
}
