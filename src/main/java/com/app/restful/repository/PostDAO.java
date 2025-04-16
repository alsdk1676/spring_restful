package com.app.restful.repository;

import com.app.restful.domain.PostDTO;
import com.app.restful.domain.PostVO;
import com.app.restful.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostDAO {

    private final PostMapper postMapper;

//    게시글 목록
    public List<PostDTO> findAll(){
        return postMapper.selectAll();
    }

//    게시글 1개 가져오기
    public Optional<PostDTO> findById(Long id){
        return postMapper.selectById(id);
    }

//    게시글 작성
    public void save(PostVO postVO){
        postMapper.insert(postVO);
    }

//    게시글 수정
    public void update(PostVO postVO){
        postMapper.update(postVO);
    }

//    게시글 삭제
    public void delete(Long id){
        postMapper.delete(id);
    }

//    게시글 삭제(회원 탈퇴시)
    public void deleteAll(Long memberId){
        postMapper.deleteAll(memberId);
    }
}
