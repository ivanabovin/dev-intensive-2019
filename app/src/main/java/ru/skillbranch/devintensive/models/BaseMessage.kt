package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extensions.humanizeDiff
import java.util.Date
import java.util.concurrent.atomic.AtomicLong

abstract class BaseMessage(
    val id: String,
    val from: User?,
    val chat: Chat,
    val isIncoming: Boolean = false,
    val date: Date = Date()
) {

    abstract fun formatMessage(): String

    protected fun formatMessage(description: String): String {
        val name = from?.firstName ?: "аноним"
        val act = if (isIncoming) "получил" else "отправил"
        val time = date.humanizeDiff()
        return "$name $act $description $time"
    }

    companion object AbstractFactory {
        private val nextId = AtomicLong(1)

        fun makeMessage(
            from: User, chat: Chat, date: Date, type: String,
            payload: Any?, isIncoming: Boolean = false
        ): BaseMessage {
            val id = nextId.getAndIncrement().toString()
            return when (type) {
                "text" -> TextMessage(id, from, chat, isIncoming, date, payload as String)
                "image" -> ImageMessage(id, from, chat, isIncoming, date, payload as String)
                else -> throw IllegalArgumentException("unknown message type: $type")
            }
        }
    }
}