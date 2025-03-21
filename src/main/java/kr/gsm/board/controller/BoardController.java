package kr.gsm.board.controller;

import jakarta.persistence.EntityNotFoundException;
import kr.gsm.board.entity.Board;
import kr.gsm.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Controller  // View를 넘겨주는
@RestController // JSON
@RequestMapping("/api")
public class BoardController { // 객체생성(new BoardController())

    @Autowired
    private BoardService boardService;

    //GET :	http://localhost:8081/api/board
    @GetMapping("/board")
    public ResponseEntity<?> getAllList(){
        return new ResponseEntity<>(boardService.findAll(),HttpStatus.OK); // List<Board> ---MessageConveter-> JSON
    }

    //POST : http://localhost:8081/api/board
    @PostMapping("/board") // JSON : { "title":"자바",...  }
    public ResponseEntity<?> register(@RequestBody Board board){
       return new ResponseEntity<>(boardService.save(board), HttpStatus.OK);
    }

    // GET : http://localhost:8081/api/board/5
    @GetMapping("/board/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Optional<Board> optional=boardService.findById(id);
        if(optional.isPresent()){
            return new ResponseEntity<>(optional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("데이터가 없습니다.", HttpStatus.NOT_FOUND);
    }

    // PUT : http://localhost:8081/api/board/2
    @PutMapping("/board/{id}")
    public ResponseEntity<?> modify(@PathVariable Long id,
                                    @RequestBody Board reqBoard){
        Board updatedBoard = boardService.save(id, reqBoard);
        //return ResponseEntity.ok(updatedBoard);
        return new ResponseEntity<>(updatedBoard, HttpStatus.OK);
    }

    // DELETE : http://localhost:8081/api/board/3
    @DeleteMapping("/board/{id}")
    public ResponseEntity<?> remove(@PathVariable Long id){
        boardService.deleteById(id);
        return new ResponseEntity<>("삭제성공", HttpStatus.OK);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> exceptionHandler(EntityNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
