package com.sdjz.cqbms.controller;


import com.sdjz.cqbms.aop.JsonResultController;
import com.sdjz.cqbms.entity.domain.SysUser;
import com.sdjz.cqbms.entity.vo.ResponseData;
import com.sdjz.cqbms.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@JsonResultController
@RequestMapping("/base")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public ResponseData login(String username, String password){

        if(loginService.checkUsername(username)==0){
            return new ResponseData("001","用户名不存在",null);
        }else{
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            //获取原密码
            String originPassword = loginService.getPassword(username);
            //校验密码 参数1 明文 参数2 密文
            boolean matches = passwordEncoder.matches(password, originPassword);
            if(matches){
                SysUser sysUser = new SysUser();
                sysUser.setUsername(username);
                sysUser.setPassword(password);
                return new ResponseData("002","登陆成功",sysUser);
            }else {
                return new ResponseData("003","登陆失败,密码不正确!",null);
            }
        }



    }
}
