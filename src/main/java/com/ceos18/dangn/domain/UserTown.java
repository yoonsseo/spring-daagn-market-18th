package com.ceos18.dangn.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Entity
@Getter
public class UserTown extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userTownId")
    private Long id;

    @ColumnDefault("2")
    private int townRange;

    private LocalDateTime townAuthTime;

    @Column(columnDefinition = "TINYINT(0) DEFAULT 0")
    private boolean isTownAuth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "townId")
    private Town town;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;


}
