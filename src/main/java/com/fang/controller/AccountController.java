package com.fang.controller;

import com.fang.bean.Account;
import com.fang.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping("save")
    @ResponseBody
    public Map<String,Object> save(Account account) {
        Map<String,Object> result = new HashMap<>();

        try{
            accountService.save(account);
            result.put("code",1);
            result.put("message","成功");
        }catch (Exception e){
            e.printStackTrace();
            result.put("code",-1);
            result.put("message","发生错误："+e.getMessage());
        }

        return result;
    }

    //produces  text/html,application/xml,application/json   chartset=UTF-8
    @RequestMapping(value = "findAll")
    @ResponseBody
    public Map<String,Object> findAll(int pageNum, int pageSize)  {
        Map<String,Object> result = new HashMap<>();

        try{
            PageInfo<Account> accountPageInfo = accountService.findAll(pageNum, pageSize);
            //System.out.println(accountPageInfo);
            result.put("code",1);
            result.put("message","成功");
            result.put("data",accountPageInfo);

        }
        catch (Exception e){
            e.printStackTrace();
            result.put("code",-1);
            result.put("message","发生错误："+e.getMessage());
        }

        //返回类型为String时，可以通过jackson将返回结果转JSON
        //ObjectMapper objectMapper = new ObjectMapper();
        //return objectMapper.writeValueAsString(accountList);
        //返回类型为list或者实体时，可以自动转JSON
        //return accountList;
        //返回类型为map,通过重新构造带返回值的参数。
        return result;
    }
}
