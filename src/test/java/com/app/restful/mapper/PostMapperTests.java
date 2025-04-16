package com.app.restful.mapper;

import com.app.restful.domain.PostVO;
import com.app.restful.repository.PostDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PostMapperTests {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private PostDAO postDAO;

    @Test
    public void selectAllTest(){
        log.info("{}", postMapper.selectAll());
    }

    @Test
    public void selectByIdTest(){
        log.info("{}", postMapper.selectById(1L));
    }

    @Test
    public void getPostService(){
        log.info("{}", postDAO.findById(10L));
    }

    @Test
    public void insertTEst() {
        PostVO postVO = new PostVO();
        postVO.setPostTitle("테스트 게시글 제목100");
        postVO.setPostContent("테스트 내용100");
        postVO.setMemberId(1L);
        postMapper.insert(postVO);
    }

    @Test
    public void updateTest(){
        PostVO postVO = new PostVO();
        postVO.setId(81L);
        postVO.setPostTitle("테스트 게시글 제목1000");
        postVO.setPostContent("테스트 내용1000");
        postMapper.update(postVO);
    }

    @Test
    public void deleteTest(){
        postMapper.delete(81L);
    }

    @Test
    public void deleteAllTest(){
        postMapper.deleteAll(2L);
    }

}
