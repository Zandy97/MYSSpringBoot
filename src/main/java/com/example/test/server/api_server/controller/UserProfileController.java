package com.example.test.server.api_server.controller;

import com.example.test.server.api_server.model.UserProfile;

import com.example.test.server.api_server.model.common.ResultMsg;
import com.example.test.server.api_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Controller
@Transactional
@Slf4j
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

    @PostMapping("/user/login_check")
    public @ResponseBody ResultMsg<UserProfile> checkLogin(UserProfile profile) {
        UserProfile login = userService.getLoginCheck(profile.getId(), profile.getPwd());
        if(login == null){
            return new ResultMsg<UserProfile>(false, "회원가입을 하세요");
        }
        return new ResultMsg<UserProfile>(true, "로그인 성공!",  login);
    }

    @PostMapping(value = "/member/join",
    consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public @ResponseBody ResultMsg<String> requestJoin(@RequestBody UserProfile profile) {
        ResultMsg<String> rslt = null;
        log.info("hahahahah");
        log.info(profile.getName()+" "+profile.getId());
        // try{
        //     userService.postRegister(profile);
        //     rslt = new ResultMsg<>(true, "가입성공");
        // }catch(Exception e){
        //     rslt = new ResultMsg<>(false, e.getMessage());
        // }
        rslt = new ResultMsg<>(true, "가입성공");
        return rslt;
    }
    
    // @RequestMapping(value = "/member/join/{id}, {pwd}, {name}, {age}", method = {RequestMethod.POST, RequestMethod.GET})
    // public @ResponseBody ResultMsg<UserProfile> create( @PathVariable ("id") String id, @PathVariable ("pwd") String pwd,
    // @PathVariable ("name") String name, @PathVariable ("age") String age) {
    //     return new ResultMsg<UserProfile>(true, "가입 성공!", userService.postRegister(id, pwd, name, age));
    // }
    
    // @RequestMapping(value = "/member/join/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    // public @ResponseBody ResultMsg<UserProfile> delIndex(@PathVariable ("id") String id) {
    //     UserProfile del =   userService.delAccount(id);
    //     if(del == null){
    //         return new ResultMsg<UserProfile>(false, "찾을 수 없음.");
    //     }
    //     return new ResultMsg<UserProfile>(true, "삭제 완료",  del);
    // }
}
