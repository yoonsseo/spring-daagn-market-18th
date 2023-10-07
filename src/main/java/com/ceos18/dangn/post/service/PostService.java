package com.ceos18.dangn.post.service;

import com.ceos18.dangn.domain.Category;
import com.ceos18.dangn.domain.Post;
import com.ceos18.dangn.domain.TradeMethod;
import com.ceos18.dangn.post.dto.PostDto;
import com.ceos18.dangn.post.dto.PostListResponseDto;
import com.ceos18.dangn.post.dto.RegisterPostRequestDto;
import com.ceos18.dangn.repository.CategoryRepository;
import com.ceos18.dangn.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = true)
    public PostListResponseDto getPostList(Pageable pageable) {
        //findAll로 갱신 순으로 가져오려고 했는데
        //생각해보니 근처 동네의 게시물만 가져와야하고
        //또 생각해보니까 사용자가 두 개의 동네를 설정할 수 있는데
        //어느 동네를 현재로 설정하고 올린 게시물인지도 알아야할 거 같은데
        //그거는 포스트 엔티티에 컬럼이 있어야할 것 같고
        //타운 엔티티에 위도와 경도를 추가했는데
        //예를 들어 근처 동네를 위도±50, 경도±50 으로 설정했을 때
        //그 위치의 동네 이름을 알려면 api가 필요할 것 같다

        Page<Post> findPosts = postRepository.findAll(pageable);

        Page<PostDto> postDtos = findPosts.map(PostDto::new);

        return new PostListResponseDto(postDtos.getTotalPages(), postDtos.getNumber(), postDtos.getContent());
    }
}
