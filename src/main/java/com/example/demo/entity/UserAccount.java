package com.example.demo.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;


@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@DynamoDbBean
public class UserAccount {
    String userName;
    String userEmail;
    String countryCode;
    Long dateCreated;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("UserName")
    public String getUserName() {
        return userName;
    }

    @DynamoDbSortKey
    @DynamoDbAttribute("UserEmail")
    public String getUserEmail() {
        return userEmail;
    }

}
