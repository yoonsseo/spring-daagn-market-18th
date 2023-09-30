package com.ceos18.dangn.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Review extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewId")
    private Long id;

    private String content;

    @Enumerated(EnumType.STRING)
    private ReviewType reviewType;

    @Enumerated(EnumType.STRING)
    private ReviewLevel reviewLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewerId")
    private User reviewer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "revieweeId")
    private User reviewee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId")
    private Post post;
}
