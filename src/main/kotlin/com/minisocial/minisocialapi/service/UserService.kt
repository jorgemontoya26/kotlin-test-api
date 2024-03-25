package com.minisocial.minisocialapi.service

import com.minisocial.minisocialapi.model.User
import com.minisocial.minisocialapi.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userRepository: UserRepository) {

    fun createUser(user: User): User? {
        val found = userRepository.findByEmail(user.email)

        return if (found == null) {
            userRepository.save(user)
            user
        } else null
    }

    fun findByID(uuid: UUID): User? = userRepository.findById(uuid)

    fun findAll(): List<User> = userRepository.findAll()

    fun deleteByID(uuid: UUID): Boolean = userRepository.deleteById(uuid)
}