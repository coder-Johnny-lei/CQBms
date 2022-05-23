package com.sdjz.cqbms.service;

import com.sdjz.cqbms.entity.domain.SysUser;
import com.sdjz.cqbms.entity.vo.LoginUser;
import com.sdjz.cqbms.exception.BusinessException;
import com.sdjz.cqbms.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * 用户验证处理
 *
 * @author ruoyi
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService
{
    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private SysUserService userService;
//
//    @Autowired
//    private SysPermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        SysUser user = userService.selectUserByName(username);
        if (StringUtils.isNull(user))
        {
            log.info("登录用户：{} 不存在.", username);
            throw new BusinessException("登录用户：" + username + " 不存在");
        }

        return createLoginUser(user);
    }

    public UserDetails createLoginUser(SysUser user)
    {
//        Set<String> menuPermission = permissionService.getMenuPermission(user);
        return new LoginUser(user.getId(), null, user, null);
//        return new LoginUser(user.getId(), user.getDeptId(), user, null);


    }
}
