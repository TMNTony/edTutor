package com.project.controller;

import com.project.model.GPTRequestDto;
import com.project.model.GPTResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
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
        GPTRequestDto request = new GPTRequestDto(model, prompt);
        GPTResponseDto response = template.postForObject(url, request, GPTResponseDto.class);
        return response.getChoices().get(0).getMessage().getContent();
    }
}

