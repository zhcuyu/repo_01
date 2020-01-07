package com.zcy.service;

import com.zcy.domain.User;

import java.util.List;

public interface IaccountService {
    /**
     * 查询所有
     * @return
     */
    public List<User> findAll();
    /**
     * 保存
     * @return
     */
    public void saveAccount(User user);
}
