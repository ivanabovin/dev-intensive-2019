package ru.skillbranch.devintensive.models

import java.util.Date

class ImageMessage(
    id: String,
    from: User?,
    chat: Chat,
    isIncoming: Boolean = false,
    date: Date = Date(),
    val image: String?
) : BaseMessage(id, from, chat, isIncoming, date) {

    override fun formatMessage(): String {
        return formatMessage("изображение \"$image\"")
    }
}