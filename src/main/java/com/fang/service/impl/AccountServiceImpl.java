package com.fang.service.impl;
import com.fang.bean.Account;
import com.fang.mapper.AccountMapper;
import com.fang.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;
    @Override
    public void save(Account account) throws IOException {

/*        //获取mybatis核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        mapper.save(account);
        sqlSession.commit();
        //关闭资源
        sqlSession.close();*/
        accountMapper.save(account);
    }

    @Override
    public PageInfo<Account> findAll(int pageNum,int pageSize) throws IOException {
       /* //获取mybatis核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        List<Account> userList = mapper.findAll();
        //打印输出
        System.out.println(userList);
        //关闭资源
        sqlSession.close();
        return userList;*/

        //设置分页
        PageHelper.startPage(pageNum,pageSize);
        List<Account> accountList = accountMapper.findAll();
        PageInfo<Account> accountPageInfo = new PageInfo<>(accountList);

        //返回结果
        return accountPageInfo;

    }
}