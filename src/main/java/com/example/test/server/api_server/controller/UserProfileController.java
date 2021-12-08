package com.example.test.server.api_server.controller;

import com.example.test.server.api_server.model.UserProfile;

import com.example.test.server.api_server.model.common.ResultMsg;
import com.example.test.server.api_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
// import lombok.extern.slf4j.Slf4j;

@Controller
@Transactional
// @Slf4j
public class UserProfileController {

    @Autowired
    UserService userService;

    @GetMapping("/user/all_list")
    public @ResponseBody ResultMsg<UserProfile> getIndex() {
        return new ResultMsg<UserProfile>(true, "회원 관리",  userService.getUserProfileList());
    }

    @GetMapping("/user/item/{id}")
    public @ResponseBody ResultMsg<UserProfile> getIndex(@PathVariable ("id") String id) {
        UserProfile item = userService.getUserProfils(id);
        if(item == null){
            return new ResultMsg<UserProfile>(false, "찾을 수 없음.");
        }
        return new ResultMsg<UserProfile>(true, "회원 정보",  item);
    }

    @PostMapping("/user/login_check") // 로그인
    public @ResponseBody ResultMsg<UserProfile> checkLogin(UserProfile profile) {
        UserProfile login = userService.getLoginCheck(profile.getId(), profile.getPwd());
        if(login == null){
            return new ResultMsg<UserProfile>(false, "회원가입을 하세요");
        }
        return new ResultMsg<UserProfile>(true, "로그인 성공!",  login);
    }

    @PostMapping(value = "/user/join") // 회원 가입
    public @ResponseBody ResultMsg<String> requestJoin(UserProfile profile) {
        ResultMsg<String> rslt = null;
        try{
            userService.userJoin(profile);
            rslt = new ResultMsg<>(true, "가입성공");
        }catch(Exception e){
            rslt = new ResultMsg<>(false, e.getMessage());
        }
            return rslt;
    }
    
    @GetMapping(value = "/member/delete/{id}")
    public @ResponseBody ResultMsg<String> requestDel(@PathVariable ("id") String id) {
        int numberDel = userService.delAccount(id);
        if(numberDel == 0){
            return new ResultMsg<String>(false, "지우는 회원 정보 찾을 수 없음.");
        }
        return new ResultMsg<String>(true, "삭제 완료");
    }
}
