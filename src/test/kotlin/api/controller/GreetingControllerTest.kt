package api.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.example.testgrpc.contracts.request.GreetingApiQuery
import org.assertj.core.api.Assertions.assertThat
import org.example.testgrpc.TestGrpcApplication
import org.example.testgrpc.api.controller.GreetingController
import org.example.testgrpc.contracts.response.Greeting
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestConstructor
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders

@WebMvcTest(
    value = [GreetingController::class],
    properties = ["spring.main.allow-bean-definition-overriding=true"],
)
@ContextConfiguration(
    classes = [
        TestGrpcApplication::class
    ]
)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class GreetingControllerTest(
    private val mockMvc: MockMvc,
    private val objectMapper: ObjectMapper,
) {

    @Test
    fun `post 요청에 올바르게 응답한다`() {
        // Arrange
        val query = GreetingApiQuery("Howard")
        val request = createRequest(query)

        // Act
        val response = mockMvc
            .perform(request)
            .andReturn()
            .response
            .contentAsString

        // Assert
        val actual = objectMapper.readValue(
            response,
            Greeting::class.java
        )
        val expected = Greeting("Welcome, ${query.name}")
        assertThat(actual)
            .usingRecursiveComparison()
            .isEqualTo(expected)
    }

    private fun createRequest(
        query: GreetingApiQuery,
    ): MockHttpServletRequestBuilder {
        return MockMvcRequestBuilders
            .post("/greeting")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .characterEncoding(Charsets.UTF_8.name())
            .content(objectMapper.writeValueAsString(query))
    }
}
