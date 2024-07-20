package com.example.splitwise;

import com.example.splitwise.Commands.CommandExecutor;
import com.example.splitwise.Commands.SettleUpUserCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {

    private CommandExecutor commandExecutor;
    private SettleUpUserCommand settleUpUserCommand;

    public SplitwiseApplication(CommandExecutor commandExecutor,
                                SettleUpUserCommand settleUpUserCommand){
        this.commandExecutor = commandExecutor;
        this.settleUpUserCommand = settleUpUserCommand;
    }

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        commandExecutor.addCommand(settleUpUserCommand);

        while(true){
            String input = scanner.next();
            commandExecutor.execute(input);
        }
    }
}
