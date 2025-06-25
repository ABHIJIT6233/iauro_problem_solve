package com.iauro.problem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iauro.problem.dto.ExpenseDTO;
import com.iauro.problem.model.Expense;
import com.iauro.problem.service.ExpenseService;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<Expense> addExpense(@RequestBody ExpenseDTO dto,
                                              @AuthenticationPrincipal UserDetails user) {
        return ResponseEntity.ok(expenseService.addExpense(dto, user.getUsername()));
    }
    @GetMapping
    public List<Expense> getAllExpenses(@AuthenticationPrincipal UserDetails user) {
        return expenseService.getAllExpenses(user.getUsername());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long id,
                                                 @RequestBody ExpenseDTO dto,
                                                 @AuthenticationPrincipal UserDetails user) {
        return ResponseEntity.ok(expenseService.updateExpense(id, dto, user.getUsername()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id,
                                              @AuthenticationPrincipal UserDetails user) {
        expenseService.deleteExpense(id, user.getUsername());
        return ResponseEntity.ok().build();
    }
}
