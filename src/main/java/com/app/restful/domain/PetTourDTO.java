package com.app.restful.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PetTourDTO {
    private String areaCode;
    private String address;
    private String dong;
    private String contentId;
    private String title;
    private String firstImage1;
    private String firstImage2;
    private String tel;
    private String zipCode;
}
