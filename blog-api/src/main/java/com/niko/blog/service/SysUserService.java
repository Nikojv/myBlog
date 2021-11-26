package com.niko.blog.service;

import com.niko.blog.dao.pojo.SysUser;

public interface SysUserService {
    SysUser findUserById(Long id);
}
