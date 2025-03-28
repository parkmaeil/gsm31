package kr.gsm.board.service;

import kr.gsm.board.entity.Book;
import kr.gsm.board.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    // @Autowired
    private final BookRepository bookRepository; // DI

    // 책 전체 목록을 가져오는 동작
    public List<Book> getAllLists(){
        return bookRepository.findAll(); //-------->SQL
    }
}
