package com.dd.springmongodemo.service;

import com.dd.springmongodemo.model.Expense;
import com.dd.springmongodemo.repository.ExpenseRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepo expenseRepo;

    public ExpenseService(ExpenseRepo expenseRepo) {
        this.expenseRepo = expenseRepo;
    }

    public void addExpense(Expense expense) {
        expenseRepo.insert(expense);
    }

    public void updateExpense(Expense expense) {
        System.out.println("Expense In Update Section " +
                expense);
        Expense savedExpense = expenseRepo.findById(expense.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Can not find by expense ID %d ", expense.getId())
                ));
        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());
        savedExpense.setExpensePrice(expense.getExpensePrice());
        expenseRepo.save(savedExpense);
    }

    public List<Expense> getAllExpense() {
        return expenseRepo.findAll();
    }

    public Expense getExpenseByName(String name) {
        return expenseRepo.findByName(name).orElseThrow(() -> new RuntimeException(
                String.format("Can not find expense for name %s", name)
        ));
    }

    public void deleteExpense(String id) {
        expenseRepo.deleteById(id);

    }
}
