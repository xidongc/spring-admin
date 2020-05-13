package mpa.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;


@Configuration
public class MConfig extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.host}")
    private String mongoHost;

    @Value("${spring.data.mongodb.port}")
    private int mongoPort;

    @Value("${spring.data.mongodb.database}")
    private String dbName;

    @Override
    public MongoClient mongoClient() {
        return new MongoClient(mongoHost, mongoPort);
    }

    @Override
    protected String getDatabaseName() {
        return dbName;
    }
}
