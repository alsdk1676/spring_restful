package com.app.restful.repository;

import com.app.restful.domain.MemberVO;
import com.app.restful.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberDAO {

    private final MemberMapper memberMapper;

//    회원가입
    public void save(MemberVO memberVO) {
        memberMapper.insert(memberVO);
    }

//    회원정보 전체 조회
    public List<MemberVO> findAll() {
        return memberMapper.selectAll();
    }

//    회원정보 조회
    public Optional<MemberVO> findById(Long id){
        return memberMapper.select(id);
    }

//    회원정보 수정
    public void update(MemberVO memberVO) {
        memberMapper.update(memberVO);
    }

//    회원탈퇴
    public void delete(Long id){
        memberMapper.delete(id);
    }
}
