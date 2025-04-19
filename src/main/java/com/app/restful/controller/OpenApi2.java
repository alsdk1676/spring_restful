package com.app.restful.controller;

import com.app.restful.domain.CongestionData;
import com.app.restful.domain.PetTourDTO;
import com.app.restful.service.OpenApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/*")
public class OpenApi2 {

    private final OpenApiService openApiService;

    @GetMapping("fetch-data")
    public List<PetTourDTO> fetchData() throws IOException {
        return openApiService.fetchData();
    }

    @GetMapping("fetch-data2")
    public List<CongestionData> fetchData2() throws IOException, URISyntaxException {
        return openApiService.fetchData2();
    }
}
