package com.fang.service;

import com.fang.bean.Account;
import com.github.pagehelper.PageInfo;
import java.io.IOException;

public interface AccountService {

    void save(Account account) throws IOException;

    PageInfo<Account> findAll(int pageNum, int pageSize) throws IOException;
}
