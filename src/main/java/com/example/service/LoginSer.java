package com.example.service;

import com.example.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录业务处理
 */
@Service
public class LoginSer {

    @Autowired
    SysUserMapper homeMapper;

    /**
     * 登录业务处理
     * @param req
     * @return
     */
    public String login(HttpServletRequest req){

        return "index";
    }
}
