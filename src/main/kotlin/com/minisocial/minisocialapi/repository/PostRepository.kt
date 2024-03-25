package com.minisocial.minisocialapi.repository

import com.minisocial.minisocialapi.model.Post
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class PostRepository {

    private val posts = listOf(
        Post(id = UUID.randomUUID(), title = "Test post 1", content = "This is the content of the post 1"),
        Post(id = UUID.randomUUID(), title = "Test post 2", content = "This is the content of the post 2")
    )

    fun findAll(): List<Post> = posts
}