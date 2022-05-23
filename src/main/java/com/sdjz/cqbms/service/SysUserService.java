package com.sdjz.cqbms.service;

import com.sdjz.cqbms.entity.domain.SysUser;
public interface SysUserService{


    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser selectUserByName(String username);

}
