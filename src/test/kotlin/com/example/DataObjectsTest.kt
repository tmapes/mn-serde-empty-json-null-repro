package com.example

import io.micronaut.serde.ObjectMapper
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@MicronautTest
class DataObjectsTest {

    @Inject
    lateinit var objectMapper: ObjectMapper

    @Test
    fun testSerdeUserInfo() {
        val input = UserInfo(null, null)
        val expectedOutput = "{}"

        val outputJson = objectMapper.writeValueAsString(input)

        Assertions.assertEquals(expectedOutput, outputJson)

        val parsedInput = objectMapper.readValue(outputJson, UserInfo::class.java)
        Assertions.assertEquals(input, parsedInput)
    }

    @Test
    fun testSerde_UserInfo_Nested() {
        val input = OuterClazz(
            name = "my_name",
            userInfo = UserInfo(null, null)
        )

        val expectedJson = """{"name":"my_name","user_info":{}}"""
        val outputJson = objectMapper.writeValueAsString(input)

        Assertions.assertEquals(expectedJson, outputJson)

        val parsedInput = objectMapper.readValue(outputJson, OuterClazz::class.java)
        Assertions.assertEquals(input, parsedInput)

    }

}
