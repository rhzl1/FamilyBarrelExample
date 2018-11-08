package com.example.service;

import com.example.mapper.HomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeSer {

    @Autowired
    HomeMapper homeMapper;

    public String index(){

        String suName = "";
        return homeMapper.getAll(suName,"15264768891").toString();
    }
}
