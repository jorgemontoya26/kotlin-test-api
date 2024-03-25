package com.minisocial.minisocialapi.model

import java.util.UUID

data class Post(
    val id: UUID,
    val title: String,
    val content: String
)
