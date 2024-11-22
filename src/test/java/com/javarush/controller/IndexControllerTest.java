package com.javarush.controller;

import org.junit.jupiter.api.Test;

import java.net.http.HttpClient;
import java.time.Duration;

import static java.net.http.HttpClient.Version.HTTP_1_1;

class IndexControllerTest {

    @Test
    public void whenOpenIndexPage_thenReturnBody() {

        // Содали аналог браузера
        HttpClient.newBuilder()
                .version(HTTP_1_1)
                .connectTimeout(Duration.ofSeconds(1))
                .build();
    }
}