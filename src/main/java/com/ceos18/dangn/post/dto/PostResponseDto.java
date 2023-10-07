package com.ceos18.dangn.post.dto;

import com.ceos18.dangn.domain.Post;
import com.ceos18.dangn.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

public class PostResponseDto {
    private Long post_id;

    private String seller_nickname;
    private String seller_town;
    private double seller_manners;

    private String title;
    private String category;
    private String description;
    private String wishplace;
    private int view;

    public PostResponseDto(Long postId, Post post, String sellerTown) {
        this.post_id = postId;

        this.seller_nickname = post.getSeller().getNickname();
        this.seller_town = sellerTown;
        this.seller_manners = post.getSeller().getManners();

        this.title = post.getTitle();
        this.category = post.getCategory().getName();
        this.description = post.getDescription();
        this.wishplace = post.getWishPlace();
        this.view = post.getView();
    }
}
