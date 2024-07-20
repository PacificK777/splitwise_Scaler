package com.example.splitwise.Repositories;

import com.example.splitwise.Models.ExpenseUser;
import com.example.splitwise.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseUserRepository extends JpaRepository<ExpenseUser, Long> {

    List<ExpenseUser> findAllByUser(User user);
}
