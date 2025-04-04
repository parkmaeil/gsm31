package kr.gsm.board.payload;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CustomerCartsDTO {
    // Customer 정보
    private String username;
    private String name;
    private int age;
    // Cart 정보
    private List<CartInfoDTO> carts;
    
}
