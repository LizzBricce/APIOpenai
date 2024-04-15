package br.com.deoo.gym.apiopenai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ChatController {

    @Qualifier("geminiRestTemplate")
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/chat")
    public String chat(@RequestParam String prompt) {

        ChatRequest request = new ChatRequest(prompt);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ChatRequest> requestEntity = new HttpEntity<>(request, headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                "https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent?key=",
                HttpMethod.POST,
                requestEntity,
                String.class
        );
        return responseEntity.toString();

    }
}
