package com.example.splitwise.Commands;

import com.example.splitwise.Controllers.SettleUpController;
import com.example.splitwise.DTOS.SettleUpGroupRequestDTO;
import com.example.splitwise.DTOS.SettleUpUserRequestDTO;
import com.example.splitwise.DTOS.SettleUpUserResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class SettleUpUserCommand implements Command{
    private SettleUpController settleUpController;

    public SettleUpUserCommand(SettleUpController settleUpController){
        this.settleUpController = settleUpController;
    }
    @Override
    public boolean matches(String input) {
        //input - 1234 SettleUp
        //words - [1234, SettleUp]
        List<String> words = List.of(input.split(" "));
        return words.size() == 2 && words.get(1).equals(CommandKeywords.settleUpCommand);
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));
        Long userId = Long.valueOf(words.get(0));

        SettleUpUserRequestDTO requestDTO = new SettleUpUserRequestDTO();
        requestDTO.setUserId(userId);

        SettleUpUserResponseDTO responseDTO = settleUpController.settleUpUser(requestDTO);

    }
}
