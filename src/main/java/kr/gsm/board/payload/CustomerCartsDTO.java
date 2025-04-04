package kr.gsm.board.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCartsDTO {
    // Customer 정보
    private String username;
    private String name;
    private int age;
    // Cart 정보
    private List<CartInfoDTO> carts;

}
