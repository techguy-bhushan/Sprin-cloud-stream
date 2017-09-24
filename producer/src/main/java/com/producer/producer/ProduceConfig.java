package com.producer.producer;

import com.producer.producer.util.ProducerChannel;
import com.producer.producer.util.UuidCaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;


@EnableBinding (ProducerChannel.class)
public class ProduceConfig {

    private Logger logger = LoggerFactory.getLogger(ProducerChannel.class.getName());
    private AtomicLong atomicLong = new AtomicLong(0);


    private final MessageChannel consumer;

    public ProduceConfig(ProducerChannel producerChannel) {
        this.consumer = producerChannel.output1();
    }


    public void publishHelloTo(String userName) {
        String greeting = String.format("Hello %s", userName);
        Message<String> message = MessageBuilder.withPayload(greeting)
                .build();
        this.consumer.send(message);
        logger.info("Send message: "+greeting);
    }

    @InboundChannelAdapter(value = ProducerChannel.OUTPUT2, poller = @Poller(fixedDelay = "1000", maxMessagesPerPoll = "1"))
    public String uuidSource() {
        UuidCaller uuidCaller = new UuidCaller(atomicLong.getAndAdd(1), new Date(), UUID.randomUUID().toString());
        logger.info("build request:"+uuidCaller);
        return uuidCaller.toString();
    }

}

