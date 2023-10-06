package com.ceos18.dangn.post.service;

import com.ceos18.dangn.domain.Category;
import com.ceos18.dangn.domain.Post;
import com.ceos18.dangn.domain.TradeMethod;
import com.ceos18.dangn.post.dto.PostDto;
import com.ceos18.dangn.post.dto.PostResponseDto;
import com.ceos18.dangn.post.dto.RegisterPostRequestDto;
import com.ceos18.dangn.repository.CategoryRepository;
import com.ceos18.dangn.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;

    public Long registerPost(RegisterPostRequestDto requestDto) {
        Post post = requestDto.toEntity();

        TradeMethod tradeMethod = TradeMethod.valueOf(requestDto.getTradeMethod());
        post.setTradeMethod(tradeMethod);

        Category category = categoryRepository.findByName(requestDto.getCategory());
        post.setCategory(category);

        postRepository.save(post);

        return post.getId();
    }


}
