package com.sdjz.cqbms.service;


import com.sdjz.cqbms.entity.vo.LoginUser;
import com.sdjz.cqbms.exception.LoginFailException;
import com.sdjz.cqbms.redis.RedisCache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class SysLoginService {
    @Resource
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private RedisCache redisCache;

    public String login(String username,String password ){
        Authentication authentication = null;
        try{
            //校验用户名和密码
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch (Exception e){
            e.printStackTrace();;
            throw new LoginFailException(username,"用户名或密码错误，请重试");
        }
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        //生成令牌
        String token = tokenService.createToken(loginUser);
        return token;
    }

}
