package com.app.restful.service;

import com.app.restful.domain.PostDTO;
import com.app.restful.domain.PostVO;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.List;
import java.util.Optional;

public interface PostService {

//    게시물 전체 조회
    public List<PostDTO> getPosts();

//    게시물 1개 조회
    public Optional<PostDTO> getPost(Long id);

//    게시글 작성
    public void write(PostVO postVO);

    public void modify(PostVO postVO);

    public void remove(Long id);

//    필요없음!
//    하나의 서비스 단위이기 때문에
//    하나의 트랜잭션으로 묶이기 떄문에
//    public void withdraw(Long memberId);
}
