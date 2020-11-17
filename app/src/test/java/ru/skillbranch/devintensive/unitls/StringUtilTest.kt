package ru.skillbranch.devintensive.unitls

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.skillbranch.devintensive.utils.stripHtml
import ru.skillbranch.devintensive.utils.truncate

class StringUtilTest {

    @Test
    fun truncate() {
        assertEquals("Bender Bending R...", "Bender Bending Rodriguez".truncate())
        assertEquals("Bender Bending...", "Bender Bending Rodriguez".truncate(15))
        assertEquals("A", "A   ".truncate(3))
    }

    @Test
    fun stripHtml() {
        assertEquals("Образовательное IT-сообщество Skill Branch",
            """<p class="title">Образовательное IT-сообщество Skill Branch</p>""".stripHtml())
        assertEquals("Образовательное IT-сообщество Skill Branch",
            "<p>Образовательное       IT-сообщество \n\n\n Skill Branch &euro;</p>".stripHtml())
    }
}
