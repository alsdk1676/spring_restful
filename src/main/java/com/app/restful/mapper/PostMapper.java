package com.app.restful.mapper;

import com.app.restful.domain.PostVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostMapper {

//    게시글 전체 조회
    public List<PostVO> selectAll();

//    개시글 단일 조회
    public Optional<PostVO> selectById(Long id);


}
