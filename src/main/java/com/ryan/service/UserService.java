package com.ryan.service;

import com.ryan.dao.UserMapper;
import com.ryan.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Date : 2019:06:14
 * @Author : Lilanzhou
 * 说明 :
 */
@Service
public class UserService {
  @Autowired
  UserMapper userMapper;
    public void insert(Integer id,String username,String password){
        userMapper.insert(id,username,password);
    }
    public int delete(Integer id){
        return userMapper.deleteByPrimaryKey(id);
    }
    public int update(Integer id,String username,String password){
        return userMapper.updateByPrimaryKey(id,username,password);
    }
    public User query(String username){
        return userMapper.queryByUsername(username);
    }
}
