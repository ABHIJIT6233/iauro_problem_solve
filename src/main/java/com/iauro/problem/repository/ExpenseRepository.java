package com.iauro.problem.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.iauro.problem.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findAllByUserUsernameOrderByCreatedAtDesc(String username);
    Optional<Expense> findByIdAndUserUsername(Long id, String username);
    void deleteByIdAndUserUsername(Long id, String username);
}
