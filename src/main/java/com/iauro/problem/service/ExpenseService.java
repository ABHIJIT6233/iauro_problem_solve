package com.iauro.problem.service;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iauro.problem.dto.ExpenseDTO;
import com.iauro.problem.model.Expense;
import com.iauro.problem.model.User;
import com.iauro.problem.repository.ExpenseRepository;
import com.iauro.problem.repository.UserRepository;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepo;

    @Autowired
    private UserRepository userRepo;

    public Expense addExpense(ExpenseDTO dto, String username) {
        User user = userRepo.findByUsername(username).orElseThrow();
        Expense expense = new Expense();
  
        expense.setCategory(dto.getCategory());
        expense.setAmount(dto.getAmount());
        expense.setComments(dto.getComments());
        expense.setCreatedAt(LocalDateTime.now());
        expense.setUpdatedAt(LocalDateTime.now());
        expense.setUser(user);
        return expenseRepo.save(expense);
    }

    public List<Expense> getAllExpenses(String username) {
        return expenseRepo.findAllByUserUsernameOrderByCreatedAtDesc(username);
    }

    public void deleteExpense(Long id, String username) {
        expenseRepo.deleteByIdAndUserUsername(id, username);
    }

    public Expense updateExpense(Long id, ExpenseDTO dto, String username) {
        Expense expense = expenseRepo.findByIdAndUserUsername(id, username).orElseThrow();
        expense.setCategory(dto.getCategory());
        expense.setAmount(dto.getAmount());
        expense.setComments(dto.getComments());
        expense.setUpdatedAt(LocalDateTime.now());
        return expenseRepo.save(expense);
    }
}
