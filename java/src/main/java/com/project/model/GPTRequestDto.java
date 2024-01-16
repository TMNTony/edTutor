package com.project.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GPTRequestDto {

    private String model;
    private List<MessageDto> messages;

    public GPTRequestDto(String model, String prompt) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new MessageDto("user", prompt));
    }
}