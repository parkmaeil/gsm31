package kr.gsm.board.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

// Board(Object)---mapping-->DB Table
// ORM
// Spring JPA API
@Entity
public class Board { // 번호(PK), 제목, 내용, 작성자....
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // null

    @Column(name = "title", length=500, nullable = false)
    private String title; // varchar(500)

    private String content;
    private String writer; // name
    private LocalDateTime createdAt;
    private int count;
}
