package kr.gsm.board.controller;

import kr.gsm.board.payload.CustomerCartsDTO;
import kr.gsm.board.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cus")
public class CustomerController {

    private final CustomerService customerService;
    // http://localhost:8081/api/cus/carts
    @GetMapping("/carts")
    public List<CustomerCartsDTO> getCartsList(){
        return customerService.getCartsList();
    }
}
