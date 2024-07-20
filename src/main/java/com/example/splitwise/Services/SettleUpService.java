package com.example.splitwise.Services;

import com.example.splitwise.Exceptions.GroupNotFoundException;
import com.example.splitwise.Exceptions.UserNotFoundException;
import com.example.splitwise.Models.Expense;
import com.example.splitwise.Models.ExpenseUser;
import com.example.splitwise.Models.Group;
import com.example.splitwise.Models.User;
import com.example.splitwise.Repositories.ExpenseRepository;
import com.example.splitwise.Repositories.ExpenseUserRepository;
import com.example.splitwise.Repositories.GroupRepository;
import com.example.splitwise.Repositories.UserRepository;
import com.example.splitwise.Strategy.SettleUpStrategy;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SettleUpService {
    private UserRepository userRepository;
    private ExpenseUserRepository expenseUserRepository;
    private SettleUpStrategy settleUpStrategy;
    private GroupRepository groupRepository;
    private ExpenseRepository expenseRepository;

    public SettleUpService(UserRepository userRepository,
                           ExpenseUserRepository expenseUserRepository,
                           SettleUpStrategy settleUpStrategy,
                           GroupRepository groupRepository,
                           ExpenseRepository expenseRepository){
        this.userRepository = userRepository;
        this.expenseUserRepository = expenseUserRepository;
        this.settleUpStrategy = settleUpStrategy;
        this.groupRepository = groupRepository;
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> settleUpUser(Long userid) throws UserNotFoundException {
        /*
        1. get the user with the given userID
        2. Get all the expenses for this user
        3. Iterate through all the expenses,find the total extra/lesser amount
           paid by every user involved in the expense.
        4. Implement min/max Heap algo to settleUp users.
         */
        Optional<User> optionalUser = userRepository.findById(userid);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("User with userid - "+userid+ " not found");
        }
        User user = optionalUser.get();

        List<ExpenseUser> expenseUsers = expenseUserRepository.findAllByUser(user);

        Set<Expense> expenses = new HashSet<>();
        for(ExpenseUser expenseUser:expenseUsers){
            expenses.add(expenseUser.getExpense());
        }

        //Settle up the expenses
        List<Expense> settleUpExpenses = settleUpStrategy.settleUp(expenses.stream().toList());
        /*
        A -> B = 500
        A -> C = 700
        D -> C = 200
         */
        List<Expense> expensesToReturn = new ArrayList<>();
        for(Expense expense : settleUpExpenses){
            for(ExpenseUser expenseUser : expense.getExpenseUsers()){
                if(expenseUser.getExpense().equals(user)){
                    expensesToReturn.add(expense);
                    break;
                }
            }
        }
        return expensesToReturn;
    }

    public List<Expense> settleUpGroup(Long groupId) throws GroupNotFoundException {
    Optional<Group> optionalGroup = groupRepository.findById(groupId);
    if(optionalGroup.isEmpty()){
        throw new GroupNotFoundException("Group with groupid - "+groupId+ " not found");
    }
    Group group = optionalGroup.get();

    //Find all the expenses for this group
    List<Expense> expenses = expenseRepository.findAllByGroup(optionalGroup.get());

    //SettleUp
    return settleUpStrategy.settleUp(expenses);
    }
}
