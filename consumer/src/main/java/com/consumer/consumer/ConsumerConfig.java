package com.consumer.consumer;

import com.consumer.consumer.util.ConsumerChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;


@EnableBinding(ConsumerChannel.class)
public class ConsumerConfig {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerChannel.class);

    @Bean
    IntegrationFlow integrationFlow(ConsumerChannel consumerChannel) {
        return IntegrationFlows.from(consumerChannel.input1()).handle(String.class, (payload, header) -> {
            logger.info("new message :"+ payload + " header:"+header);
            return null;
        })
                .get();
    }

    @StreamListener(ConsumerChannel.INPUT2)
    public void loggerUuidCaller(String uuidCaller) {
        logger.info("Received: " + uuidCaller);
    }
}
