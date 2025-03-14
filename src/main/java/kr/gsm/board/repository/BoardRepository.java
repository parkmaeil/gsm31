package kr.gsm.board.repository;

import kr.gsm.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {
    //public List<Board> findAll(); --> Hibernate엔진 SQL생성
    // findAll() --> select * from Board
    // save(Board board)
}
// public class EntityManager implements BoardRepository{

// }