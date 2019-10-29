package com.sample.aac.data.model

import java.io.Serializable

data class UserResponse(
    val login: String,
    val id: Int,
    val node_id: String,
    val avatar_url: String,
    val gravatar_id: String,
    val url: String,
    val location: String
) : Serializable