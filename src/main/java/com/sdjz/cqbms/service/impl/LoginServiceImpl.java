package com.sdjz.cqbms.service.impl;

import com.sdjz.cqbms.mapper.LoginMapper;
import com.sdjz.cqbms.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;


    @Override
    public int checkUsername(String username) {
        return loginMapper.checkUserName(username);
    }

    @Override
    public String getPassword(String username) {
        return loginMapper.getPassword(username);
    }
}
