package com.app.restful.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootTest
@Slf4j
public class OpenApiTests {

    @Autowired
    private OpenApiService openApiService;

    @Test
    public void openApiTest() throws IOException {
        openApiService.fetchData();
    }

    @Test
    public void openApiTest2() throws IOException, URISyntaxException {
        openApiService.fetchData2();
    }
}
