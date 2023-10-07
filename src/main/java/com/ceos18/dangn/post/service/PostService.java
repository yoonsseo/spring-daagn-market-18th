package com.ceos18.dangn.post.service;

import com.ceos18.dangn.domain.*;
import com.ceos18.dangn.post.dto.PostDto;
import com.ceos18.dangn.post.dto.PostListResponseDto;
import com.ceos18.dangn.post.dto.PostResponseDto;
import com.ceos18.dangn.post.dto.RegisterPostRequestDto;
import com.ceos18.dangn.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;
    private final UserTownRepository userTownRepository;
    private final UserRepository userRepository;

    public Long registerPost(RegisterPostRequestDto requestDto) {
        //로그인된 유저의 올바른 정보가 넘어온다고 가정
        User seller = userRepository.findById(requestDto.getUser_id()).get();

        Post post = requestDto.toEntity(seller);

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

    public PostResponseDto getPost(Long postId) {
        Optional<Post> findPost = postRepository.findById(postId);
        if (findPost.isPresent()) {
            //조회수 올려주기!
            postRepository.updateView(postId);

            Post post = findPost.get();

            //편의상 첫 번째 주소로 가정..
            String sellerTown = userTownRepository.findByUser(post.getSeller()).get(0).getTown().getTownName();

            return new PostResponseDto(postId, post, sellerTown);
        }
        else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "게시물 없음");
        }
    }
}
