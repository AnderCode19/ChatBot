package com.example.chatbotbackend.controller;

import com.example.chatbotbackend.dto.MessageRequest;
import com.example.chatbotbackend.service.OpenAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ChatController {

    @Autowired
    private OpenAIService openAIService;

    //este metodo se va a encargar de hacer el llamado a la API y que nos retorne la respuesta
    @PostMapping("/chat")
    public String chat(@RequestBody MessageRequest request) {
        try {
            return openAIService.askGPT(request.getMessage());
        } catch (Exception e) {
            return "Error al comunicarse con OpenAI: " + e.getMessage();
        }
    }
}
