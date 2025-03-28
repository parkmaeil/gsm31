package kr.gsm.board.service;

import kr.gsm.board.entity.Book;
import kr.gsm.board.entity.BookDTO;
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
        List<Book> books=bookRepository.findAll();
        // 리뷰정보 가져오기 ?

        return books.stream().map((book)->{
            return new BookDTO(book.getId(),book.getTitle(),book.getPrice(),book.getAuthor(),book.getPage(),null);
        }).toList(); //-------->SQL
    }
}
