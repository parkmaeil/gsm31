package kr.gsm.board.service;

import kr.gsm.board.entity.Book;
import kr.gsm.board.entity.Customer;
import kr.gsm.board.payload.*;
import kr.gsm.board.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional(readOnly = true)
    public List<CustomerCartsDTO> getCartsList(String username){
        List<Customer> customers=customerRepository.findAllWithCartsAndBooks(username); // 1번SQL
        // 리뷰정보 가져오기 ?
        return customers.stream().map((customer)->{
            //List<Review> reviews=book.getReviews();//EntityManager를 접근
            //                          N번의 SQL(성능떨어진다-->N+1 해결?, fetch join, @EntityGraph)
            List<CartInfoDTO> cartInfoDTOList=customer.getCarts().stream().map((cart)->{
                Book book=cart.getBook();
                BookInfoDTO bookInfoDTO=new BookInfoDTO(book.getTitle(), book.getAuthor(), book.getPrice());
                return new CartInfoDTO(cart.getQuantity(), cart.getCartDate(), bookInfoDTO);
            }).toList();
            return new CustomerCartsDTO(customer.getUsername(), customer.getName(), customer.getAge(), cartInfoDTOList);
        }).toList();
    }
}
