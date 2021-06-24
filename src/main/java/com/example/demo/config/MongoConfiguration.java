package com.example.demo.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import static java.util.Collections.singletonList;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.demo")
public class MongoConfiguration extends AbstractMongoClientConfiguration {

    @Value("${mongo.database}")
    String DATABASE_NAME;

    @Value("${mongo.user}")
    String MONGO_USER;

    @Value("${mongo.password}")
    String MONGO_PASSWORD;

    @Value("${mongo.authDB}")
    String MONGO_AUTH_DB;

    public String getDatabaseName() {
        return DATABASE_NAME;
    }

    @Override
    protected void configureClientSettings(MongoClientSettings.Builder builder) {

        builder
                .credential(MongoCredential.createCredential(MONGO_USER, MONGO_AUTH_DB, MONGO_PASSWORD.toCharArray()))
                .applyToClusterSettings(settings  -> {
                    settings.hosts(singletonList(new ServerAddress("127.0.0.1", 27017)));
                });
    }

    public @Bean MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), DATABASE_NAME);
    }

}
