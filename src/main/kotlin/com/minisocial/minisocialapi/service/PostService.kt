package com.minisocial.minisocialapi.service

import com.minisocial.minisocialapi.model.Post
import com.minisocial.minisocialapi.repository.PostRepository
import org.springframework.stereotype.Service


@Service
class PostService(private val postRepository: PostRepository) {
    fun findAll(): List<Post> = postRepository.findAll()
}