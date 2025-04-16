package com.app.restful.service;

import com.app.restful.domain.MemberVO;

import java.util.List;
import java.util.Optional;

public interface MemberService {

//    회원가입
    public void join(MemberVO memberVO);

//    회원정보 전체 조회
    public List<MemberVO> getMembers();

//    회원정보 조회
    public Optional<MemberVO> getMemberInfo(Long id);

//    회원정보 수정
    public void modify(MemberVO memberVO);

//    회원탈퇴
    public void withdraw(Long id);
}
