package kr.gsm.board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Cart { // 장바구니(구매)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity; // 수량
    private LocalDateTime cartDate;// 구매일자

    @PrePersist
    public void onCreate(){
        this.cartDate=LocalDateTime.now();
    }
    // 구매(N) - 고객(1) 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    // 구매(N) - 책(1) 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
}
