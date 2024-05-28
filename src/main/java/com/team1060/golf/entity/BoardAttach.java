package com.team1060.golf.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_board_attach")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardAttach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attachNo;
    private String path;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boardNo")
    private Board board;
}
