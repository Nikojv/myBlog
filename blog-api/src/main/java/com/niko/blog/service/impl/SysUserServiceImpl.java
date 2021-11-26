package com.niko.blog.service.impl;

import com.niko.blog.dao.mapper.SysUserMapper;
import com.niko.blog.dao.pojo.SysUser;
import com.niko.blog.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findUserById(Long id) {
        SysUser sysUser = SysUserMapper.selectById(id);
        if (sysUser == null){
            sysUser = new SysUser();
            sysUser.setNickname("Niko");
        }
        return sysUser;
    }
}
