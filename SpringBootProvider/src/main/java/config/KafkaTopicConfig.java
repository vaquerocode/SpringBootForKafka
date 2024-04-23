package config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {
    public NewTopic generateTopic(){
        Map<String,String> configurations = new HashMap<>();
        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG,TopicConfig.CLEANUP_POLICY_DELETE);
        configurations.put(TopicConfig.RETENTION_MS_CONFIG,"86400000");//tiempo de retencion en ms de mensajes defecto -1 no se borran nunca
        configurations.put(TopicConfig.SEGMENT_MS_CONFIG,"1073741824");//tamaño  maximo del segmento 1Gb representado en bytes
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG,"1000012");// tamaño maximo de cada mensaje por defecto 1 mb
        return TopicBuilder.name("topic-example")
                .partitions(2)
                .replicas(2)
                .configs(configurations)
                .build();
    }
}
