package com.sdjz.cqbms.controller;

import com.sdjz.cqbms.aop.JsonResultController;
import com.sdjz.cqbms.entity.ao.LoginBody;
import com.sdjz.cqbms.entity.domain.SysUser;
import com.sdjz.cqbms.entity.vo.LoginUser;
import com.sdjz.cqbms.exception.BusinessException;
import com.sdjz.cqbms.service.LoginService;
import com.sdjz.cqbms.service.SysLoginService;
import com.sdjz.cqbms.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@JsonResultController
@Slf4j
@RequestMapping("/sys")
public class SysLoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private SysLoginService sysLoginService;

    @PostMapping("/login")
    public Map<String,Object> sysLogin(@RequestBody LoginBody loginBody){
        String username = loginBody.getUsername();
        //1.校验用户名称是否存在
        if(loginService.checkUsername(username)==0){
            throw new BusinessException("用户不存在!");
        }
        //2.生成令牌
        String token = sysLoginService.login(username, loginBody.getPassword());
        return getUserInfo(token);
    }

    private Map<String,Object> getUserInfo(String token){
        LoginUser loginUser = tokenService.getLoginUserByToken(token);
        SysUser sysUser = loginUser.getUser();
        Map<String,Object> map = new HashMap<>();
        map.put("token",token);
        map.put("user",sysUser);
        return  map;
    }
}
