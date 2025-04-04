package kr.gsm.board.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartInfoDTO {
    private int quantity;
    private LocalDateTime cartDate;
    private BookInfoDTO book;
}
