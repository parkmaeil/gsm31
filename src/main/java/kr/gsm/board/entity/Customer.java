package kr.gsm.board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Customer { // 고객(1)-리뷰(N) / 고객(1)-구매(N)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username; // 고객아이디
    private String password; // 암호(암호화) 12345->#?12Ade~

    private String name;
    private int age;
    // 고객-리뷰의 관계
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Review> reviews;

    // 고객-구매의 관계
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Cart> carts;
}
