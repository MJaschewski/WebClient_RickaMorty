package com.example.webclient_rickamorty.controller;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class RickAndMortyControllerTest {

    @Autowired
    MockMvc mvc;

    private static MockWebServer mockWebServer;

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("rick-api-url",() -> mockWebServer.url("/").toString());
    }

    @BeforeAll
    static void startMockWebServer() throws Exception {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
    }

    @AfterAll
    static void stopMockWebServer() throws Exception {
        mockWebServer.shutdown();
    }

    @Test
    void getAllCharacters() throws Exception {

        mockWebServer
                .enqueue(new MockResponse()
                        .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .setBody("""
                            {
                            "results": [
                                                        {
                                                          "id": "1",
                                                          "name": "Test",
                                                          "status": "Dead",
                                                          "species": "TestHuman"
                                                        }
                                                      ]
                                                    }
                        """));

        mvc.perform(get("/R&M/character"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("results[0].id").value("1"))
                .andExpect(jsonPath("results[0].name").value("Test"))
                .andExpect(jsonPath("results[0].status").value("Dead"));
    }

}