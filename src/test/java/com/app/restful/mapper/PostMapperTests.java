package com.app.restful.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PostMapperTests {

    @Autowired
    private PostMapper postMapper;

    @Test
    public void selectAllTest(){
        log.info("{}", postMapper.selectAll());
    }

    @Test
    public void selectByIdTest(){
        log.info("{}", postMapper.selectById(1L));
    }
}
