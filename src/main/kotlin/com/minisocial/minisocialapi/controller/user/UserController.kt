package com.minisocial.minisocialapi.controller.user

import com.minisocial.minisocialapi.model.Role
import com.minisocial.minisocialapi.model.User
import com.minisocial.minisocialapi.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping("/api/user")
class UserController(private val userService: UserService) {


    @PostMapping
    fun createUser(@RequestBody userRequest: UserRequest): UserResponse =
        userService.createUser(
            user = userRequest.toModel()
        )
            ?.toResponse()
            ?: throw  ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot create user")

    @GetMapping
    fun listAll(): List<UserResponse> = userService.findAll().map { it.toResponse() }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): UserResponse = userService.findByID(id)
        ?.toResponse()
        ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot find user")

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: UUID): ResponseEntity<Boolean> {
        val success = userService.deleteByID(id)

        return if (success)
            ResponseEntity.noContent().build()
        else
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "User with id : $id not found")
    }


    private fun UserRequest.toModel() : User =
        User(
            id = UUID.randomUUID(),
            email = this.email,
            password = this.password,
            role = Role.USER
        )

    private fun User.toResponse() : UserResponse =
        UserResponse(
            uuid = this.id,
            email = this.email
        )
}