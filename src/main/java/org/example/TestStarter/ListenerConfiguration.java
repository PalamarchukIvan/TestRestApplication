package org.example.TestStarter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListenerConfiguration {
    @Bean
    public InitListener initListener(){
        return new InitListener();
    }

    @Bean
    public PreDestroyListener preDestroyListener(){
        return new PreDestroyListener();
    }
}
