package com.dd.springmongodemo.dbconfig;

import com.dd.springmongodemo.model.Expense;
import com.dd.springmongodemo.model.ExpenseCategory;
import com.dd.springmongodemo.repository.ExpenseRepo;
import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.dd.springmongodemo.model.ExpenseCategory.*;

@ChangeLog
public class DatabaseChangeLog {

    @ChangeSet(order = "001", id = "seedDefaultData", author = "Doulsab Dodamani")
    public void seedDefaultData(ExpenseRepo expenseRepo) {
        List<Expense> expenseList = new ArrayList<>();
        expenseList.add(addNewExpense("Gym", ENTERTAINMENT, BigDecimal.valueOf(2000)));
        expenseList.add(addNewExpense("Movies Tickets", ENTERTAINMENT, BigDecimal.valueOf(500)));
        expenseList.add(addNewExpense("Rice ", GROCERIES, BigDecimal.valueOf(500)));
        expenseList.add(addNewExpense("Dinner Meal", RESTAURANT, BigDecimal.valueOf(500)));
        expenseList.add(addNewExpense("Petroleum", UTILITIES, BigDecimal.valueOf(500)));
        expenseRepo.insert(expenseList);
    }

    private Expense addNewExpense(String expenseName, ExpenseCategory expenseCategory, BigDecimal expenseAmt) {
        Expense expense = new Expense();
        expense.setExpenseName(expenseName);
        expense.setExpenseCategory(expenseCategory);
        expense.setExpensePrice(expenseAmt);
        return expense;
    }
}
