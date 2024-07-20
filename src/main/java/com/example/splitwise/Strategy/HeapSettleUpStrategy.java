package com.example.splitwise.Strategy;

import com.example.splitwise.Models.Expense;

import java.util.List;

public class HeapSettleUpStrategy implements SettleUpStrategy{
    @Override
    public List<Expense> settleUp(List<Expense> expenses) {

        return List.of();

    }
}
 /*
        if you have all the expenses, iterate through all these expenses, find total extra amount paid by
        total lesser amount paid by, put extra amount paid by in max heap and lesser amount paid by in min heap
        while min and max heap is not empty, keep on getting the maximum for max heap and minimum from min heap
        and try to settleup on of them and whatever was the minimum amount remove that element from the corresponding
        heap. Do the same till the time both the heaps are not empty
         */