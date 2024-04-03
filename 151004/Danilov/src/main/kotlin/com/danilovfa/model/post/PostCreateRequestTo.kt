package com.danilovfa.model.post

import kotlinx.serialization.Serializable

@Serializable
data class PostCreateRequestTo(
    val storyId: Long,
    val content: String
)