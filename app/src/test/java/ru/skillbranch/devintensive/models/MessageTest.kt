package ru.skillbranch.devintensive.models

import org.junit.Assert.*
import org.junit.Test
import ru.skillbranch.devintensive.utils.TimeUnits
import ru.skillbranch.devintensive.utils.add
import java.util.*

class MessageTest {
    private val user = User.Factory.makeUser("Василий")
    private val chat = Chat()

    @Test
    fun text() {
        val message = BaseMessage.AbstractFactory.makeMessage(user, chat, Date(), "text", "any text message")
        assertEquals("""Василий отправил сообщение "any text message" только что""", message.formatMessage())
    }

    @Test
    fun image() {
        val date = Date().add(-2, TimeUnits.HOUR)
        val message = BaseMessage.AbstractFactory.makeMessage(user, chat, date, "image", "https://anyurl.com", true)
        assertEquals("""Василий получил изображение "https://anyurl.com" 2 часа назад""", message.formatMessage())
    }
}