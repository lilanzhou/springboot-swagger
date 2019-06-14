package com.ryan.dao;

import com.ryan.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(@Param("id") Integer id, @Param("username") String username,@Param("password") String password);

    int insertSelective(User record);

    User queryByUsername(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(@Param("id") Integer id, @Param("username") String username,@Param("password") String password);

}