package com.example.splitwise.Commands;

import java.util.List;

public class RegisterUserCommand implements Command{
    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));
        return words.size() == 4 && words.get(0).equals(CommandKeywords.RegisterCommand);
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));
    }
}
