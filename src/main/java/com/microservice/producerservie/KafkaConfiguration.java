package com.microservice.producerservie;

import com.microservice.producerservie.model.PublishRequest;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfiguration {
    @Value(value = "${kafka.server_endpoint}")
    private String kafkaServerEndpoint;

    @Bean
    public ProducerFactory<String, PublishRequest> producerFactory() {
        Map<String, Object> configurationMap = new HashMap<>();
        configurationMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServerEndpoint);
        configurationMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configurationMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configurationMap);
    }

    @Bean
    public KafkaTemplate<String, PublishRequest> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
