package org.cmobile.config;

import java.net.UnknownHostException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories({"org.cmobile.repository","com.cognizant.cmobile.impl.repository"})
@PropertySource("database.properties")
@Profile("dev")
public class DatabaseConfigurationDevelopment {

	@Autowired
	Environment env;
	@Autowired
	MongoDbFactory mongoDbFactory;

	@Bean
	public MongoDbFactory mongoDbFactory() throws UnknownHostException, ParseException {
		MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(
				new MongoClient(env.getProperty("host"), Integer.parseInt(env.getProperty("port"))),
				env.getProperty("databaseName"));
		return mongoDbFactory;
	}

	@Bean
	public MongoTemplate mongoTemplate() throws UnknownHostException {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory);

		return mongoTemplate;
	}
}
