package com.example

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
@JsonInclude(JsonInclude.Include.NON_NULL)
data class OuterClazz(
    val name: String,
    @JsonProperty("user_info") val userInfo: UserInfo? = null,
)

@Serdeable
@JsonInclude(JsonInclude.Include.NON_NULL)
data class UserInfo(
    @JsonProperty("job_code") val jobCode: String? = null,
    val roles: String? = null,
)