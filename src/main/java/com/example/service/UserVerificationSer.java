package com.example.service;

import com.example.mapper.SysPermissionMapper;
import com.example.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * security用户验证处理
 */
@Component
public class UserVerificationSer implements UserDetailsService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Autowired
    SysPermissionMapper sysPermissionMapper;

    @Override
    public UserDetails loadUserByUsername(String suName) throws UsernameNotFoundException {

        Map<String,Object> sysUser = sysUserMapper.selectQueryBySuName(suName);//获取用户信息

        if(sysUser != null){
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();//存放用户权限
            List<Map<String,Object>> sysPermission = sysPermissionMapper.selectPermissionAll(sysUser.get("suId").toString());
            sysPermission.forEach(permission ->{
                if(permission.containsKey("spName")){
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.get("spName").toString());
                    grantedAuthorities.add(grantedAuthority);
                }
            });
            return new User(sysUser.get("suName").toString(),sysUser.get("suPass").toString(),  grantedAuthorities);
        }else{
            throw new UsernameNotFoundException("用户名不存在");
        }
    }
}
