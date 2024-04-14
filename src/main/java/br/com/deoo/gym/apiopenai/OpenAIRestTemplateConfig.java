package br.com.deoo.gym.apiopenai;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class OpenAIRestTemplateConfig {

    @Value("${openai.api.key}")
    private String openaiApiKey;
            //"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";

    @Bean
    @Qualifier("opneaiRestTemplate")
    public RestTemplate openairestTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer " + openaiApiKey);
            return execution.execute(request, body);
        });
        return restTemplate;
    }
}
