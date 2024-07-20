package com.example.splitwise.Strategy;

import com.example.splitwise.Models.Expense;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SettleUpStrategy {
    List<Expense> settleUp(List<Expense> expenses);
}
