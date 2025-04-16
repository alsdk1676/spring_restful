package com.app.restful.controller;

import com.app.restful.domain.PostDTO;
import com.app.restful.domain.PostVO;
import com.app.restful.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts/api/*")
@RequiredArgsConstructor
@Slf4j
public class PostController {

    public final PostService postService;

//    게시글 전체 조회
    @Operation(summary = "게시글 전체 조회", description = "게시글 정보를 전체 조회할 수 있는 API")
    @GetMapping("posts")
    public List<PostDTO> getPosts(){
        return postService.getPosts();
    }

//    게시글 1개 조회
//    옵셔널보다 꺼내오는 게 좋음
    @Operation(summary = "게시글 정보 조회", description = "게시글 1개 정보를 조회할 수 있는 API")
    @Parameter(
            name = "id",
            description = "게시글 번호",
            schema = @Schema(type = "number"), // 스키마 타입, 자바 타입X, swagger에서 정의되고 있는 타입
            in = ParameterIn.PATH, // 어디에서 받는지
            required = true
    )
    @GetMapping("post/{id}")
    public PostDTO getPost(@PathVariable Long id){
        log.info("{}", id);
        Optional<PostDTO> foundPost = postService.getPost(id);
        if(foundPost.isPresent()){
            return foundPost.get();
        }
        return new PostDTO();
    }


//    게시글 작성
//    제목 길어질 경우 쿼리스트링 깨질 수 있기 때문에 Post로 보내기
    @Operation(summary = "게시글 작성", description = "게시글을 작성할 수 있는 API")
    @ApiResponse(responseCode = "200", description = "게시글 작성 성공")
    @PostMapping("write")
        // 프론트 => 백 PostVO postVO 어디 영역에서 오는거 ? RequestBody에서 들고옴
    public PostDTO write(@RequestBody PostVO postVO){
        log.info("{}", postVO);
        postService.write(postVO); // 아이디 없음 (SEQ로 증가시키기 때문에) => SEQ를 먼저 증가시키기 //시크릿키 => id 생김
//        작성 후에는 리다이렉트, 페이지에 관여하지 않기 떄문에 리다이렉트 못시킴 => 작성 완료된 상태값과 데이터 넘겨주기
//        데이터 넘겨주기 위해 작성한 글 다시 가져오기
        Optional<PostDTO> foundPost = postService.getPost(postVO.getId()); // null값, SEQ로 해결하기
        if(foundPost.isPresent()){
            return foundPost.get();
        }
        return new PostDTO();
    }


//    게시글 수정 (PUT)
//    PUTMapping : 모든 컬럼을 수정할 때
//    PatchMapping : 부분 컬럼을 수정할 때
    @Operation(summary = "게시글 수정", description = "게시글 정보를 수정할 수 있는 API")
    @Parameter(
            name = "id",
            description = "게시글 번호",
            schema = @Schema(type = "number"),
            in = ParameterIn.PATH,
            required = true
    )
    @PutMapping("post/{id}")
    public PostDTO modify(@PathVariable Long id, @RequestBody PostVO postVO){
        postVO.setId(id); // id값 없기 때문에 먼저 넣어준 후 수정하기
        postService.modify(postVO);
        Optional<PostDTO> foundPost = postService.getPost(postVO.getId());
        if(foundPost.isPresent()){
            return foundPost.get();
        }
        return new PostDTO();
    }


//    게시글 삭제
    @Operation(summary = "게시글 삭제", description = "게시글을 삭제할 수 있는 API")
    @ApiResponse(responseCode = "200", description = "게시글 삭제 성공") // 선택사항
    @Parameter(
            name = "id",
            description = "게시글 번호",
            schema = @Schema(type = "number"),
            in = ParameterIn.PATH,
            required = true
    )
    @DeleteMapping("post/{id}")
    public void remove(@PathVariable Long id){
        postService.remove(id);
    }

}
