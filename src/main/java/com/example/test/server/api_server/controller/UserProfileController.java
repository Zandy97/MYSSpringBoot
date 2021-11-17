package com.example.test.server.api_server.controller;

import java.util.List;

import com.example.test.server.api_server.mapper.UserProfileMapper;
import com.example.test.server.api_server.model.UserProfile;

import com.example.test.server.api_server.model.common.ResultMsg;
import com.example.test.server.api_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserProfileController {

    @Autowired
    UserService userService;

    @GetMapping("/user/all_list")
    public @ResponseBody ResultMsg<UserProfile> getIndex() {
        return new ResultMsg<UserProfile>(true, "Anything you want to send",  userService.getUserProfileList());
    }

    @GetMapping("/user/item/{id}")
    public @ResponseBody ResultMsg<UserProfile> getIndex(@PathVariable ("id") String id) {
        UserProfile item = userService.getUserProfile(id);
        if(item == null){
            return new ResultMsg<UserProfile>(false, "찾을 수 없음.");
        }
        return new ResultMsg<UserProfile>(true, "Anything you want to send",  item);
    }

}
