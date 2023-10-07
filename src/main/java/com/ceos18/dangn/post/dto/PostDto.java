package com.ceos18.dangn.post.dto;

import com.ceos18.dangn.domain.Post;

public class PostDto {
    private Long post_id;
    private String title;
    private String thumbnail;
    private int price;
    private int view;
//    private String seller_town;

    public PostDto(Post post) {
        this.post_id = post.getId();
        this.title = post.getTitle();
        this.thumbnail = post.getThumbnail();
        this.price = post.getPrice();
        this.view = post.getView();
//        this.seller_town = seller_town;
    }
}
