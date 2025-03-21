package kr.gsm.board.repository;

import kr.gsm.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Spring Data JPA
@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {
    // 1. 상속받은 메서드를 사용하는 방법
    //public List<Board> findAll(); --> Hibernate엔진 SQL생성
    // findAll() --> select * from Board
    // save(Board board)
    // findById(Long id) -> select * from Board where id=?
    // deleteById()
    // 2. 규칙이 있는 메서드를 사용하는 방법(select) - Query Method
    public Optional<Board> findByTitle(String title);
}
// public class EntityManager implements BoardRepository{

// }