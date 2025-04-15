package com.app.restful.mapper;

import com.app.restful.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MemberMapperTests {

    @Autowired
    private MemberService memberService;

    @Test
    public void memberSelectTest(){
        log.info("{}", memberService.getMemberInfo(1L));
    }
}
