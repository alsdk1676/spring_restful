package com.app.restful.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CongestionData {

    @JsonProperty("요일")
    private String day;

    @JsonProperty("호선")
    private String line;

    @JsonProperty("역번호")
    private String stationNumber;

    @JsonProperty("역명")
    private String stationName;

    @JsonProperty("방향") // 매핑을 시켜주려는 key값
    private String dirction;

    @JsonProperty("7:00~ (%)")
    private String time0700;

    @JsonProperty("7:30~ (%)")
    private String time0730;

    @JsonProperty("8:00~ (%)")
    private String time0800;

    @JsonProperty("8:30~ (%)")
    private String time0830;

    @JsonProperty("9:00~ (%)")
    private String time0900;

}
