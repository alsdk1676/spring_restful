package com.app.restful.service;

import com.app.restful.domain.PetTourDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OpenApiService {

    private final PetTourDTO petTourDTO;
    //    springframework, lombok X
    @Value("${api.base-url}")
    private String baseUrl;

    @Value("${api.service-key}")
    private String serviceKey;

    @Value("${api.area-based-list}")
    private String areaBasedList;

    private final ObjectMapper objectMapper;

//    레거시
    public List<PetTourDTO> fetchData() throws IOException {

        List<PetTourDTO> petTourList = new ArrayList<PetTourDTO>();

//        URL
        String urlStr = UriComponentsBuilder.fromUriString(baseUrl + areaBasedList)
            .queryParam("serviceKey", serviceKey)
            .queryParam("MobileOS", "ETC")
            .queryParam("MobileApp", "TestApp")
            .queryParam("_type", "json")
            .build().toString();

        URL url = new URL(urlStr);
    //    log.info("{}", url);
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
        StringBuilder result = new StringBuilder();
        String line;
        while((line = br.readLine()) != null) {
            result.append(line);
        }

        br.close();
//        log.info("API Response : {}", result.toString());
        JsonNode jsonResponse = objectMapper.readTree(result.toString()); // json 형태로 바뀜

        if(jsonResponse.has("error")) { // has : jsonNode를 json 객체로 읽음
            return null;
        }

//        log.info("{}", jsonResponse.get("response").get("body").get("items").get("item")); // JSONArray
        JsonNode itemsArray = jsonResponse.get("response").get("body").get("items").get("item");
        for(JsonNode item : itemsArray) {
            log.info("{}", item); // 받아온 값이기 떄문에 반복문 돌면서 DTO에 담기
            PetTourDTO petTour = new PetTourDTO();
            petTour.setAreaCode(item.get("areacode").asText()); // asText : JsonNode를 String 타입으로 바꿔줌
            petTour.setTitle(item.get("title").asText());
            petTour.setContentId(item.get("contentid").asText());
            petTour.setAddress(item.get("addr1").asText());
            petTour.setFirstImage1(item.get("firstimage").asText());
            petTour.setFirstImage2(item.get("firstimage2").asText());
            petTour.setTel(item.get("tel").asText());
            petTour.setZipCode(item.get("zipcode").asText());
            petTourList.add(petTour);
        }

        log.info("PetTourList: {}", petTourList);
        return petTourList;
    }

//    resttemplates


}
