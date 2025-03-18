package kr.gsm.board.controller;

import kr.gsm.board.entity.Board;
import kr.gsm.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@Controller  // View를 넘겨주는
@RestController // JSON
@RequestMapping("/api")
public class BoardController { // 객체생성(new BoardController())

    @Autowired
    private BoardService boardService;

    //GET :	http://localhost:8081/api/board
    @GetMapping("/board")
    public List<Board> getAllList(){
        return boardService.findAll(); // List<Board> ---MessageConveter-> JSON
    }
    //POST : http://localhost:8081/api/board
    @PostMapping("/board") // JSON : { "title":"자바",...  }
    public Board register(@RequestBody Board board){
       return boardService.save(board);
    }

    
}
