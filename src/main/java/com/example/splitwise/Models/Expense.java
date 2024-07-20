package com.example.splitwise.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
public class Expense extends BaseModel{
    private String description;
    private int amount;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;

    @OneToMany(mappedBy = "expense")
    private List<ExpenseUser> expenseUsers;

    @ManyToOne
    private User createdBy;

    @ManyToOne
    private Group group;

    /*
       1            M
    expense----expenseUser => 1:M
       1            1

       1         1
    expense----group => M:1
       M         1


     */
}
