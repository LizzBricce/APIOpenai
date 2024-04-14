package br.com.deoo.gym.apiopenai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ChatController {

    @Qualifier("openaiRestTemplate")
    @Autowired
    private RestTemplate restTemplate;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;

    @GetMapping("/chat")
    public  String chat(@RequestParam String prompt){
        //criando a requisiçao

        ChatRequest request = new ChatRequest((model, prompt));

        //chamando a pi
        ChatResponse response = restTemplate.postForObject((apiUrl, request, ChatResponse.class));

        if(response == null || response.getChoices() == null || response.getChoices().isEmpty()){
            return "no response";
        }

        //retorna a primeira resposta

        return response.getChoices().get(0).getMessage().getContent();
    }

}
