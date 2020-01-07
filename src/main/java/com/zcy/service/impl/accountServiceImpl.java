package com.zcy.service.impl;

import com.zcy.dao.IaccountDao;
import com.zcy.domain.User;
import com.zcy.service.IaccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("accountService")
public class accountServiceImpl implements IaccountService {
    @Autowired
    private IaccountDao accountDao;
    @Override
    public List<User> findAll() {
        System.out.println("业务层：查询所有账户");
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(User user) {
        System.out.println("业务层：保存账户");
        accountDao.saveAccount(user);
    }
}
