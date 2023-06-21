/**
 * Copyright (c) 2021, by Arlo Technologies, Inc. All rights reserved.
 *
 * This software is the confidential and proprietary information of Arlo Technologies, Inc.
 * ("Confidential Information"). You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement you entered into with
 * Arlo Technologies, Inc.
 */
package com.example.demo.dao;


import com.example.demo.entity.UserAccount;

import java.util.Optional;

public interface UserAccountRepository {

    Optional<UserAccount> loadByPrimaryKeyAndSortKey(String hashKey, String sortKey);

}
