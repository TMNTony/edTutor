package com.project.controller;

import com.project.dto.GPTRequestDto;
import com.project.dto.GPTResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/GPT")
public class GPTController {
    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String url;

    @Autowired
    private RestTemplate template;

    @GetMapping("/chat")
    public String chat(@RequestParam("prompt") String prompt) {
        try {
            GPTRequestDto request = new GPTRequestDto(model, prompt);
            GPTResponseDto response = template.postForObject(url, request, GPTResponseDto.class);
            return response.getChoices().get(0).getMessage().getContent();
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred");

        }
    }
}

