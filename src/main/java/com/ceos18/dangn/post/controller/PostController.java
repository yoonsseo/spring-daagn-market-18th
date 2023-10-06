package com.ceos18.dangn.post.controller;

import com.ceos18.dangn.post.dto.PostResponseDto;
import com.ceos18.dangn.post.dto.RegisterPostRequestDto;
import com.ceos18.dangn.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity registerPost(@RequestBody RegisterPostRequestDto requestDto) {
        postService.registerPost(requestDto);
        return ResponseEntity.ok().build();
    }


}
