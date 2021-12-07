package com.example.test.server.api_server.service;

import com.example.test.server.api_server.mapper.UserProfileMapper;
import com.example.test.server.api_server.model.UserProfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserProfileMapper userMapper;

    public List<UserProfile> getUserProfileList(){
        return userMapper.getUserProfileList();
    }

    public UserProfile getUserProfils(String id){
        return userMapper.getUserProfile(id);
    }

    public UserProfile getLoginCheck(String id, String pwd){
        return userMapper.getLoginCheck(id, pwd);
    }

    public UserProfile userJoin(String id, String pwd, String name, String age){
        return userMapper.userJoin(id, pwd, name, age);
    }

    public int delAccount(String id){
        return userMapper.deleteUserProfile(id);
    }

}
