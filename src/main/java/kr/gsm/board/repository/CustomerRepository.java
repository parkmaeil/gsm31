package kr.gsm.board.repository;

import kr.gsm.board.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // JPQL : N+1
    @Query("""
           SELECT DISTINCT c FROM Customer c
           LEFT JOIN FETCH c.carts ct
           LEFT JOIN FETCH ct.book
           """)
    public List<Customer> findAllWithCartsAndBooks();
}
