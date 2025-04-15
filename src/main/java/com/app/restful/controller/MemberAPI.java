package com.app.restful.controller;

import com.app.restful.domain.MemberVO;
import com.app.restful.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/members/api/*") // restful이니까 복수 + api
@RequiredArgsConstructor

// RestController 의 리턴 타입은 JSON 타입
public class MemberAPI {

    private final MemberService memberService;

//    url 파라미터 : 모든 컨트롤러에서 사용이 가능하지만 보통 rest에서 사용된다.
    @GetMapping("member/{id}")
    public MemberVO getMember(@PathVariable Long id) { // url 파라미터 값을 key와 value로 매핑
        Optional<MemberVO> foundMember = memberService.getMemberInfo(id); // 파라미터 값 넘겨줌
        if(foundMember.isPresent()){
//            get()없이 옵셔널로 보내도 되지만, 정확한 데이터를 가져와 안전하게 처리하기 위해서 get()으로 꺼내옴
            return foundMember.get();
        }
//        데이터가 없을 떄 null값을 리턴해주면 NPE 발생
//        => 프론트에서 요청이 들어왔을 때 NPE 발생하기 때문에 좋지 않은 코드
//        => null 값으로 리턴하지 않고 빈 객체로 리턴하기!
//        잘못 전달하면 빈 객체를 전달한다.
//        exception 보다는 null을 보내서 값을 잘못 전달하게 처리한다.
//        그래서 대부분 Optional로 안보낼때가 많지만 상세하게 전달할 때에는 Optional로 전달한다.
        return new MemberVO();
    }
}
