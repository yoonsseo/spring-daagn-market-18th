package com.ceos18.dangn.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @NotNull
    private String phone;

    private String email;

    @NotNull
    private String nickname;

    @NotNull
    private String password;

    @NotNull
    private Role role;

    private String profileImage;

//    매너온도 고민
    @ColumnDefault("36.5")
    private double manners;

    @Builder
    public User(String phone, String nickname, String password, Role role) {
        this.phone = phone;
        this.nickname = nickname;
        this.password = password;
        this.role = role;
    }
}
