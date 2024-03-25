package com.minisocial.minisocialapi.repository

import com.minisocial.minisocialapi.model.Role
import com.minisocial.minisocialapi.model.User
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class UserRepository {
    private val users = mutableListOf(
        User(id = UUID.randomUUID(), email = "testuser1@mail.com", password = "pass1", role = Role.ADMIN),
        User(id = UUID.randomUUID(), email = "testuser2@mail.com", password = "pass2", role = Role.USER),
        User(id = UUID.randomUUID(), email = "testuser3@mail.com", password = "pass3", role = Role.USER),
    )


    fun save(user: User): Boolean = users.add(user)

    fun findByEmail(email: String): User? = users.firstOrNull { it.email == email }

    fun findAll(): List<User> = users

    fun findById(uuid: UUID): User? = users.firstOrNull { it.id == uuid }

    fun deleteById(uuid: UUID): Boolean {
        val foundUser = findById(uuid)


        return foundUser?.let { users.remove(it) } ?: false
    }
}