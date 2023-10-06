package com.ceos18.dangn.post.dto;

import com.ceos18.dangn.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RegisterPostRequestDto {
    private String thumbnail;
    private String title;
    private String category;
    private String tradeMethod;
    private int price;
    private boolean isPriceOffer;
    private String description;
    private String wishPlace;
    private int townRange;

    public Post toEntity() {
        return Post.builder()
                .thumbnail(thumbnail)
                .title(title)
                .price(price)
                .isPriceOffer(isPriceOffer)
                .description(description)
                .wishPlace(wishPlace)
                .townRange(townRange)
                .build();
    }
}
