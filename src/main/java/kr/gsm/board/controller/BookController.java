package kr.gsm.board.controller;

import kr.gsm.board.payload.BookDTO;
import kr.gsm.board.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bapi")
public class BookController {

    private final BookService bookService;

    // GET : /bapi/books
    @GetMapping("/books")
    public List<BookDTO> getAllLists(){
        List<BookDTO> books=bookService.getAllLists();
        return books;
        //  List<BookDTO> ---HttpMessageConverter----> JSON
        //                   @Entity 해석(연관관계?)
        // 1. 순환참조문제 ? DTO 클래스를 만들어서 해결
        //  [
        //    {id, title, price, author, page,[],[]},
        //    {id, title, price, author, page,[],[]},
        //    {id, title, price, author, page,[],[]},
        //    {id, title, price, author, page,[],[]},
        //    {id, title, price, author, page,[],[]}
        //  ]
    }
}
