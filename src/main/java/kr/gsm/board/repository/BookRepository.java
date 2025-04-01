package kr.gsm.board.repository;

import kr.gsm.board.entity.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // JPQL -> N+1 : fetch join
    @Query("select DISTINCT b from Book b left join fetch b.reviews")
    public List<Book> findWithReviews();

    @EntityGraph(attributePaths = {"reviews"})
    @Override
    public List<Book> findAll();

    // 책과 리뷰정보와 고객 정보를 함께 가져오시오 : JPQL
    @Query("""
           SELECT DISTINCT b FROM Book b
           LEFT JOIN FETCH b.reviews r
           LEFT JOIN FETCH r.customer
           """)
    public List<Book> findAllWithReviewsAndCustomer();
}
