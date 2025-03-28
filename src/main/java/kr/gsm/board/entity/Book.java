package kr.gsm.board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String title;
    private int price;
    private String author;
    private int page;
    // 책 - 리뷰의 관계(1:1, N:1,1:N, M:N)
    @OneToMany(mappedBy ="book", cascade = CascadeType.ALL,
               fetch = FetchType.LAZY)
    private List<Review> reviews;

    // 책 - 구매의 관계
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL,
               fetch = FetchType.LAZY)
    private List<Cart> carts;
}