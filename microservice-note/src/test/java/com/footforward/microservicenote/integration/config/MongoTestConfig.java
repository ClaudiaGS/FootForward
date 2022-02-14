package com.footforward.microservicenote.integration.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Collection;
import java.util.Collections;

//@TestConfiguration
//@EnableMongoRepositories(basePackages = "com.footforward.microservicenote.repositories")
//public class MongoTestConfig {
//
//    @Bean
//    @Primary
//    public MongoClient mongo() {
//        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/noteTestDB");
//        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
//                .applyConnectionString(connectionString)
//                .build();
//
//        return MongoClients.create(mongoClientSettings);
//    }
//
//    @Bean
//    @Primary
//    public MongoTemplate mongoTemplate() throws Exception {
//        return new MongoTemplate(mongo(), "noteTestDB");
//    }
//}
@TestConfiguration
@EnableMongoRepositories(basePackages = "com.footforward.microservicenote.repositories")
@Primary
public class MongoTestConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "noteTestDB";
    }
  
    @Override
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/noteTestDB");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Override
    public Collection getMappingBasePackages() {
        return Collections.singleton("com.footforward.microservicenote");
    }
}