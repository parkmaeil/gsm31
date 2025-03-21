package kr.gsm.board.repository;

import kr.gsm.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    // findBy+객체의 속성이름
    // public Optional<Board> getByTitle(String title);
    // public Optional<Board> getByTitle(String title);
    // 3. JPQL(사용자 정의 쿼리)
    // - Entity를 기준으로 SQL을 작성
    //@Query("select b from Board b where b.title=?1")
    //public Optional<Board> getTitle(String title);
    // - Table을 기준으로 SQL을 작성
    @Query(value = "select * from board where title=?1", nativeQuery = true)
    public Optional<Board> getTitle(String title);
}
// public class EntityManager implements BoardRepository{

// }