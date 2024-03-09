package com.dd.springmongodemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Document("expense")
public class Expense {
    @Id
    private String id;
    @Field(name = "name")
    @Indexed(unique = true)
    private String expenseName;
    @Field(name = "category")
    private ExpenseCategory expenseCategory;
    @Field(name = "price")
    private BigDecimal expensePrice;
// Constructor

    public Expense(String id, String expenseName, ExpenseCategory expenseCategory, BigDecimal expensePrice) {
        this.id = id;
        this.expenseName = expenseName;
        this.expenseCategory = expenseCategory;
        this.expensePrice = expensePrice;
    }

    public Expense() {

    }
//    Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public ExpenseCategory getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(ExpenseCategory expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public BigDecimal getExpensePrice() {
        return expensePrice;
    }

    public void setExpensePrice(BigDecimal expensePrice) {
        this.expensePrice = expensePrice;
    }
//    toString()

    @Override
    public String toString() {
        return "Expense{" +
                "id='" + id + '\'' +
                ", expenseName='" + expenseName + '\'' +
                ", expenseCategory=" + expenseCategory +
                ", expensePrice=" + expensePrice +
                '}';
    }
}
