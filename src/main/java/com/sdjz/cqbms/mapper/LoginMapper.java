package com.sdjz.cqbms.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {

    int login(@Param("username") String username, @Param("password") String password);

    int checkUserName(String username);

    String getPassword(String username);
}
