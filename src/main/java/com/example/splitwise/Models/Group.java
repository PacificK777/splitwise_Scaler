package com.example.splitwise.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "splitwise_groups")
public class Group extends BaseModel{
    private String name;
    private String description;

    @ManyToOne
    private User createdBy; //admin

    @ManyToMany
    private List<User> members;

    @OneToMany
    private List<Expense> expenses;

    /*
      1       M
    group----member => M:M
      M       1

      1         M
    group----expense => 1:M
      1         1

      1        1
    group----admin => M:1
      M        1
     */
}
