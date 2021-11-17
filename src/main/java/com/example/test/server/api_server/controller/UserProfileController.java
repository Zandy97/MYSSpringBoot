package com.example.test.server.api_server.controller;

import java.util.List;

import com.example.test.server.api_server.mapper.UserProfileMapper;
import com.example.test.server.api_server.model.UserProfile;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserProfileController {
    
    private UserProfileMapper mapper;

    public UserProfileController(UserProfileMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping("/user/{id}")
    public UserProfile getUserProfile(@PathVariable("id") String id) {
        return mapper.getUserProfile(id);
    }

    @GetMapping("/user/all")
    public List<UserProfile> getUserProfileList() {
        return mapper.getUserProfileList();
    }

    @PutMapping("/user/{id}")
    public void putUserProfile(@PathVariable("id") String id, @RequestParam("pwd") String pwd, 
    @RequestParam("name") String name, @RequestParam("age") String age) {
        mapper.insertUserProfile(id, pwd, name, age);
    }

    @PostMapping("/user/{id}")
    public void postUserProfile(@PathVariable("id") String id, @RequestParam("pwd") String pwd, 
    @RequestParam("name") String name, @RequestParam("age") String age) {
        mapper.updateUserProfile(id, pwd, name, age);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserProfile(@PathVariable("id") String id) {
        mapper.deleteUserProfile(id);
    }
}
