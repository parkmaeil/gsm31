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

    public void deleteById(Long id){
       Optional<Board> optional=boardRepository.findById(id);
       if(optional.isPresent()){
           boardRepository.deleteById(id);
       }else{
           throw new EntityNotFoundException("Board not found with id: " + id);
       }
    }

    // 조회수 증가
    public void addCount(Long id){
        Optional<Board> optional=boardRepository.findById(id);
        Board board=optional.get();
        board.setCount(board.getCount()+1);
        boardRepository.save(board); // 수정
    }

    // 책의 제목이 일치하는 책(Board)을 가져오기?
    public Optional<Board> findByTitle(String title){
        return boardRepository.getTitle(title);
    }
}
