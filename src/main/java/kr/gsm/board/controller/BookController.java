package kr.gsm.board.controller;

import kr.gsm.board.entity.Book;
import kr.gsm.board.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
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
    public List<Book> getAllLists(){
        List<Book> books=bookService.getAllLists();
        return books;
        //  List<Book> ---HttpMessageConverter----> JSON
        //                  @Entity 해석(연관관계?)
        //  [
        //    {id, title, price, author, page,[],[]},
        //    {id, title, price, author, page,[],[]},
        //    {id, title, price, author, page,[],[]},
        //    {id, title, price, author, page,[],[]},
        //    {id, title, price, author, page,[],[]}
        //  ]
    }
}
