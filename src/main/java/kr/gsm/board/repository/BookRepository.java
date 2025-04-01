package kr.gsm.board.repository;

import kr.gsm.board.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // JPQL -> N+1 : fetch join
    @Query("select b from Book b left join fetch b.reviews")
    public List<Book> findWithReviews();
}
