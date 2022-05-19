package com.sdjz.cqbms.service;


public interface LoginService {

    //校验用户名是否存在
    int checkUsername(String username);


    //获取密文密码(用户名唯一)
    String getPassword(String username);

}
