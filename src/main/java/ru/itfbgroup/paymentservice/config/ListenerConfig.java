package ru.itfbgroup.paymentservice.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class ListenerConfig {

    @Value("${message.food-delivery-queue}")
    private String queueName;

    @Value("${message.payment-routing-key}")
    private String routingKey;


    @Bean
    public TopicExchange receiverExchange() {
        return new TopicExchange("eventExchange");
    }

    @Bean
    public Queue eventReceivingQueue() {
        if (queueName == null) {
            throw new IllegalStateException("No queue to listen to! Please specify the name of the queue to listen to with the property 'subscriber.queue'");
        }
        return new Queue(queueName);
    }

    @Bean
    public Binding binding(Queue eventReceivingQueue, TopicExchange receiverExchange) {
        if (routingKey == null) {
            throw new IllegalStateException("No events to listen to! Please specify the routing key for the events to listen to with the property 'subscriber.routingKey' (see EventPublisher for available routing keys).");
        }
        return BindingBuilder
                .bind(eventReceivingQueue)
                .to(receiverExchange)
                .with(routingKey);
    }

    @Bean
    public Jackson2JsonMessageConverter jacksonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

}