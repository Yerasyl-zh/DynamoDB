package com.example.demo.config;

import com.example.demo.dao.UserAccountRepository;
import com.example.demo.dao.UserAccountRepositoryImpl;
import com.example.demo.entity.UserAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import static com.example.demo.constant.TableConstant.USER_ACCOUNT_TABLE;

@Configuration
public class  DynamoDBConfig {

    @Bean
    DynamoDbClient setDynamoDbClient() {
        String profileName = "default";
        AwsCredentialsProvider credentialsProvider = ProfileCredentialsProvider.builder()
                .profileName(profileName)
                .build();

        return DynamoDbClient.builder()
                .credentialsProvider(credentialsProvider)
                .region(Region.EU_WEST_3)
                .build();
    }

    @Bean
    DynamoDbEnhancedClient setEnhancedClient(DynamoDbClient dynamoDbClient) {
        return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dynamoDbClient)
                .build();
    }

    @Bean
    public UserAccountRepository setUserAccountRepository(DynamoDbEnhancedClient enhancedClient) {
        return new UserAccountRepositoryImpl(enhancedClient.table(USER_ACCOUNT_TABLE, TableSchema.fromBean(UserAccount.class)));
    }

}
