package com.minisocial.minisocialapi.controller.post

import com.minisocial.minisocialapi.model.Post
import com.minisocial.minisocialapi.service.PostService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/post")
class PostController(private val postService: PostService) {


    @GetMapping
    fun listAll(): List<PostResponse> = postService.findAll()
        .map { it.toResponse() }

    private fun Post.toResponse(): PostResponse = PostResponse(id = this.id, title = this.title, content = this.content)

}