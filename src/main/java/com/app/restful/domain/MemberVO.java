package com.app.restful.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
@Schema(description = "회원 정보")
public class MemberVO implements Serializable { // Serializable : 직렬화가 되는 객체
    @Schema(description = "회원 번호", required = true, example = "41")
    private Long id;
    @Schema(description = "회원 이메일", required = true, example = "test@app.com")
    private String memberEmail;
    @Schema(description = "회원 비밀번호", required = true, example = "비공개")
    private String memberPassword;
    @Schema(description = "회원 이름", required = true, example = "홍길동")
    private String memberName;
}
