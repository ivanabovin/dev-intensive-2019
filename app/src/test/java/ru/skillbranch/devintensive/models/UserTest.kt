package ru.skillbranch.devintensive.models

import org.junit.Assert.assertEquals
import org.junit.Test

class UserTest {

    @Test
    fun factory() {
        val user = User.Factory.makeUser("")
        assertEquals(User(user.id, null, null, null, lastVisit = user.lastVisit), user)
    }

    @Test
    fun builder() {
        val user = User.Builder()
            .id("1")
            .firstName("F")
            .lastName("L")
            .avatar("A")
            .rating(1)
            .respect(2)
            .lastVisit(null)
            .isOnline(true)
            .build()
        assertEquals(User("1", "F", "L", "A", 1, 2, null, true), user)
    }
}