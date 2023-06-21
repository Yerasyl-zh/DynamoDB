package com.example.demo.dao ;

import com.example.demo.entity.UserAccount;
import lombok.AllArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;

import java.util.Optional;

@AllArgsConstructor
public class  UserAccountRepositoryImpl implements UserAccountRepository {

    DynamoDbTable<UserAccount> table;

    public Optional<UserAccount> loadByPrimaryKeyAndSortKey(String hashKey, String sortKey) {
        Key key = Key.builder()
                .partitionValue(hashKey)
                .sortValue(sortKey)
                .build();
        return Optional.ofNullable(table.getItem(key));
    }
}
