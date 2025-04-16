package com.app.restful.service;

import com.app.restful.domain.MemberVO;
import com.app.restful.mapper.MemberMapper;
import com.app.restful.repository.MemberDAO;
import com.app.restful.repository.PostDAO;
import lombok.RequiredArgsConstructor;
import org.apache.el.lang.ELArithmetic;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;
    private final PostDAO postDAO;

//    회원가입
    @Override
    public void join(MemberVO memberVO) {
        memberDAO.save(memberVO);
    }

//    회원 전체 조회
    @Override
    public List<MemberVO> getMembers() {
        return memberDAO.findAll();
    }

//    회원 단일 조회
    @Override
    public Optional<MemberVO> getMemberInfo(Long id) {
        return memberDAO.findById(id);
    }

//    회원정보 수정
    @Override
    public void modify(MemberVO memberVO) {
        memberDAO.update(memberVO);
    }

//    회원탈퇴
    @Override
    public void withdraw(Long id) {
        postDAO.deleteAll(id);
        memberDAO.delete(id);
    }
}
