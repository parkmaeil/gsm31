package kr.gsm.board.service;

import kr.gsm.board.entity.Book;
import kr.gsm.board.entity.BookDTO;
import kr.gsm.board.entity.Review;
import kr.gsm.board.entity.ReviewDTO;
import kr.gsm.board.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    // @Autowired
    private final BookRepository bookRepository; // DI

    // 책 전체 목록을 가져오는 동작
    @Transactional(readOnly = true)
    public List<BookDTO> getAllLists(){
        // 순환참조문제 해결 ? BookDTO
        List<Book> books=bookRepository.findAll(); // 1번SQL
        // 리뷰정보 가져오기 ?
        return books.stream().map((book)->{
            //List<Review> reviews=book.getReviews();//EntityManager를 접근
            //                          N번의 SQL(성능떨어진다-->N+1 해결?, fetch join, @EntityGraph)
            List<ReviewDTO> reviewDTOS=book.getReviews().stream().map((review)->{
               return new ReviewDTO(review.getId(), review.getCost(), review.getContent(), review.getCreatedAt());
            }).toList();
            return new BookDTO(book.getId(),book.getTitle(),book.getPrice(),book.getAuthor(),book.getPage(),reviewDTOS);
        }).toList(); //-------->SQL
    }// 끝나기 전까지 EntityManager를 Open
}
