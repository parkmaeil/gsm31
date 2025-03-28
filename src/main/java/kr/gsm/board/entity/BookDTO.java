package kr.gsm.board.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private Long id;
    private String title;
    private int price;
    private String author;
    private int page;
    //private LocalDateTime createdAt;
    // 리뷰 ?
    private List<Review> reviews;

}
