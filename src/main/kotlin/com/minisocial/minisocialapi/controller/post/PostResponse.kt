package com.minisocial.minisocialapi.controller.post

import java.util.*

data class PostResponse(
    val id: UUID,
    val title: String,
    val content: String
)
