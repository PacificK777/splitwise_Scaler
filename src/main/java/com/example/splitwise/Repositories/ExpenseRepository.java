package com.example.splitwise.Repositories;

import com.example.splitwise.Models.Expense;
import com.example.splitwise.Models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findAllByGroup(Group group);
}
