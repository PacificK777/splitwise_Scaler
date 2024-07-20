package com.example.splitwise.DTOS;

import com.example.splitwise.Models.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SettleUpUserResponseDTO {
    private List<Expense> expenses;
}
