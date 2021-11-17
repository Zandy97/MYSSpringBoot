package com.example.test.server.api_server.service;

import com.example.test.server.api_server.mapper.UserProfileMapper;
import com.example.test.server.api_server.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserProfileMapper userMapper;

    public List<UserProfile> getUserProfileList(){
        return userMapper.getUserProfileList();
    }

    public UserProfile getUserProfile(String id){
        return userMapper.getUserProfile(id);
    }

}
