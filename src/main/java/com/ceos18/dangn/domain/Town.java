package com.ceos18.dangn.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Town extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "townId")
    private Long id;

    private String townName; //방배동
    private String districtName; //서초구
    private String stateName; //서울시
}
