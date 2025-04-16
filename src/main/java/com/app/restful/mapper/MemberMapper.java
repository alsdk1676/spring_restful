package com.app.restful.mapper;

import com.app.restful.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {

//    회원 가입
    public void insert(MemberVO memberVO);

//    회원 정보 전체 조회
    public List<MemberVO> selectAll();

//    회원 정보 조회
    public Optional<MemberVO> select(Long id);

//    회원 정보 수정
    public void update(MemberVO memberVO);

//    회원 탈퇴
    public void delete(Long id);

}
