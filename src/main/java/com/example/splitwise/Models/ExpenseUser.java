package com.example.splitwise.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ExpenseUser extends BaseModel{
    @ManyToOne
    private User user;

    @ManyToOne
    private Expense expense;
    private int amount;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseUserType expenseUserType;

    /*
        1           1
    ExpenseUser----user =>M:1
        M           1

        1           1
    expenseUser---expense => M:1
        M           1
     */
}
