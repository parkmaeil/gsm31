package kr.gsm.board.service;

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

    public Board findById(Long id){
        Optional<Board> optional=boardRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }
}
