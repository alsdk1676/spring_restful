package com.app.restful.controller;

import com.app.restful.domain.MemberVO;
import com.app.restful.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/members/api/*") // restful이니까 복수 + api
@RequiredArgsConstructor

// RestController 의 리턴 타입은 JSON 타입
public class MemberAPI {

    private final MemberService memberService;

//    회원가입 (성공 시 or 실패 시 - flash : 세션을 공유하고 있을 때 사용)
    @Operation(summary = "회원가입", description = "회원가입을 할 수 있는 API")
    @ApiResponse(responseCode = "200", description = "회원가입 성공")
    @PostMapping("join")
    public MemberVO join(@RequestBody MemberVO memberVO) {

        memberService.join(memberVO);
        Optional<MemberVO> foundMember = memberService.getMemberInfo(memberVO.getId());
        if(foundMember.isPresent()) {
            return foundMember.get();
        }
        return new MemberVO();
    }

//    회원가입 성공 시 or 실패 시
//    Map<String, Object> response = new HashMap<>();
//    response.put("message", "로그인 성공하였습니다.");
//    return response

//    회원정보 단일 조회
//    url 파라미터 : 모든 컨트롤러에서 사용이 가능하지만 보통 rest에서 사용된다.
    @Operation(summary = "회원 정보 조회", description = "회원 1명의 정보를 전체 조회할 수 있는 API")
    @ApiResponse(responseCode = "200", description = "회원정보 조회 성공")
    @Parameter(
            name = "id",
            description = "회원 번호",
            schema = @Schema(type = "number"),
            in = ParameterIn.PATH,
            required = true
    )
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

//    회원정보 전체 조회
    @Operation(summary = "전체 회원정보 조회", description = "전체 회원 정보를 조회할 수 있는 API")
    @ApiResponse(responseCode = "200", description = "전체 회원정보 조회 성공")
    @GetMapping("members")
    public List<MemberVO> getMembers() {
        return memberService.getMembers();
    }

//    회원정보 수정
    @Operation(summary = "회원 정보 수정", description = "회원 정보를 수정할 수 있는 API")
    @ApiResponse(responseCode = "200", description = "회원정보 수정 성공")
    @Parameter(
            name = "id",
            description = "회원 번호",
            schema = @Schema(type = "number"),
            in = ParameterIn.PATH,
            required = true
    )
//    @PutMapping("member/{id}")
    @PutMapping("modify")
    public void modify(@RequestBody MemberVO memberVO) {
//        memberVO.setId(id);
        memberService.modify(memberVO);
//        Optional<MemberVO> foundMember = memberService.getMemberInfo(id);
//        if(foundMember.isPresent()) {
//            return foundMember.get();
//        }
//        return new MemberVO();
    }

//    회원 탈퇴
    @Operation(summary = "회원 탈퇴", description = "회원 탈퇴 할 수 있는 API")
    @ApiResponse(responseCode = "200", description = "회원탈퇴 성공")
    @DeleteMapping("withdraw/{id}")
    public void withdraw(@PathVariable Long id) {
//        세션에 저장된 회원의 id
//        Long memberId = 1L;
        memberService.withdraw(id);
    }


}
