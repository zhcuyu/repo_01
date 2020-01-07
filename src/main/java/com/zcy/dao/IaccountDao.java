package com.zcy.dao;

import com.zcy.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("accountDao")
public interface IaccountDao {
    @Select("select * from account")
    public List<User> findAll();
    @Insert("insert into account (name,money) value (#{name},#{money})")
    public void saveAccount(User user);
}
