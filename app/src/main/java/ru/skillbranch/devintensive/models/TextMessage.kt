package ru.skillbranch.devintensive.models

import java.util.Date

class TextMessage(
    id: String,
    from: User?,
    chat: Chat,
    isIncoming: Boolean = false,
    date: Date = Date(),
    val text: String?
) : BaseMessage(id, from, chat, isIncoming, date) {

    override fun formatMessage(): String {
        return formatMessage("сообщение \"$text\"")
    }
}