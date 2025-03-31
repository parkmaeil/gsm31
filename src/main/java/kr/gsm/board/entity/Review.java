package kr.gsm.board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Review { // 리뷰 - 책
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cost; //평점(1~5)
    private String content; // 내용
    private LocalDateTime createdAt; // 작성일
    @PrePersist
    public void onCreate(){
        this.createdAt=LocalDateTime.now();
    }
    // 리뷰-책 관계(1:1, 1:N,N:1, M:N)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book; // Book의 id를 가리키는 키(FK)

    // 리뷰-고객 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;// Customer의 id를 가리키는 키(FK)
}
