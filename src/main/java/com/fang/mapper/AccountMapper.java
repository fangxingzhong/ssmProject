package com.fang.mapper;

import com.fang.bean.Account;

import java.util.List;

public interface AccountMapper {
    void save(Account account);

    List<Account> findAll();
}
