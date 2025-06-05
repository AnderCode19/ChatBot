package com.example.chatbotbackend.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class OpenAIService {
    @Value("${openai.api.key}")

    //esto se encarga de leer la clave del Api
    private String apiKey;

    //esto se encarga de enviar la pregunta a la IA y obtener su respuesta
    public String askGPT(String prompt) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String body = """
        {
          "model": "gpt-3.5-turbo",
          "messages": [{"role": "user", "content": "%s"}]
        }
        """.formatted(prompt);

        // hacemos que el servidor haga la petición HTTP POST con la URL
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.openai.com/v1/chat/completions")) //URL de la API
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(body)) // la respuesta en formato JSON
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Imprime la respuesta para saber si hay errores
        System.out.println("Respuesta OpenAI: " + response.body());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.body());
        JsonNode choices = root.path("choices");
        if (choices.isArray() && choices.size() > 0) {
            return choices.get(0).path("message").path("content").asText();
        } else {

            // Intenta devolver el error de OpenAI si existe
            JsonNode error = root.path("error");
            if (!error.isMissingNode()) {
                return "OpenAI error: " + error.toString();
            }
            return "Error: no se pudo obtener la respuesta de OpenAI";
        }
    }
}
