package kr.gsm.board.entity;

import jakarta.persistence.*;

// Board(Object)---mapping-->DB Table
// ORM
// Spring JPA API
@Entity
public class Board { // 번호(PK), 제목, 내용, 작성자....
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num; // null

    @Column(name = "title", length=500, nullable = false, unique = true )
    private String title; // varchar(500)

    private String content;
    private String name; // name
}
