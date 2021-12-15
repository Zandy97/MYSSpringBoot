package com.example.test.server.api_server.controller;

import java.time.LocalDate;

import com.example.test.server.api_server.model.TodoList;
import com.example.test.server.api_server.model.common.ResultMsg;
import com.example.test.server.api_server.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TodoListController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/member/todo_list") // todolist
    public @ResponseBody ResultMsg<String> todoSave(TodoList todoList) {
    // ,@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        ResultMsg<String> rsg = null;
        try{
            userService.memberTodo(todoList);
            rsg = new ResultMsg<>(true, "succese");
        }catch(Exception e){
            rsg = new ResultMsg<>(false, e.getMessage());
        }
            return rsg;
    }
}
