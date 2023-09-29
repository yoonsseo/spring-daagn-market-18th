package com.ceos18.dangn.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class User extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long id;

    @NotNull
    private String phone;
    private String email;
    private String nickname;
    private String profileImage;

//    매너온도 고민

}
