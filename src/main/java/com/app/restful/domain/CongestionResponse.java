package com.app.restful.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class CongestionResponse {
    private Integer currentCount;
    private Integer matchCount;
    private Integer page;
    private Integer perPage;
    private Integer totalCount;
    private List<CongestionData> data;
}
