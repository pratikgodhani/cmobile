package org.cmobile.config;

import java.net.UnknownHostException;
import java.text.ParseException;

import org.json.JSONArray;
import org.json.JSONObject;
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
import com.mongodb.MongoClientURI;

@Configuration
@EnableMongoRepositories({"org.cmobile.repository","com.cognizant.cmobile.impl.repository"})
@PropertySource("database.properties")
@Profile("appfog")
public class DatabaseConfiguration {

	@Autowired
	Environment env;
	@Autowired
	MongoDbFactory mongoDbFactory;

	@Bean
	public MongoDbFactory mongoDbFactory() throws UnknownHostException, ParseException {
		JSONObject jsonObject = new JSONObject(System.getenv("VCAP_SERVICES"));
		JSONArray jsonArray = new JSONArray(jsonObject.get("mongodb-1.8").toString());
		
		JSONObject firstObject = new JSONObject(jsonArray.get(0).toString());
		JSONObject credentialsObject = new JSONObject(firstObject.get("credentials").toString());
		MongoClientURI mongoClientURI = new MongoClientURI(credentialsObject.get("url").toString());
		MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(
				new MongoClient(mongoClientURI), credentialsObject.get("db").toString());
		
		return mongoDbFactory;
	}

	@Bean
	public MongoTemplate mongoTemplate() throws UnknownHostException {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory);

		return mongoTemplate;
	}
}
