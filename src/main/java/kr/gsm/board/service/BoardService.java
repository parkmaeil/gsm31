package kr.gsm.board.service;

import jakarta.persistence.EntityNotFoundException;
import kr.gsm.board.entity.Board;
import kr.gsm.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService { // --> new BoardService() : Spring Container(DI, AOP)

    @Autowired // DI(의존성주입)
    private BoardRepository boardRepository;

    public List<Board> findAll(){
        return boardRepository.findAll(); // select SQL ~
    }

    public Board save(Board board){
        return boardRepository.save(board); // insert SQL~
    }

    public Optional<Board> findById(Long id){
        // 추가적인 작업~~
        return boardRepository.findById(id); // select SQL ~
    }

    public Board save(Long id, Board reqBoard) {
        return boardRepository.findById(id)
                .map(board -> {
                    board.setTitle(reqBoard.getTitle());
                    board.setContent(reqBoard.getContent());
                    return boardRepository.save(board);
                })
                .orElseThrow(() -> new EntityNotFoundException("Board not found with id: " + id));
    }

    public Board deleteById(Long id){
        return boardRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Board not found with id: " + id)
        );
    }
    
}
