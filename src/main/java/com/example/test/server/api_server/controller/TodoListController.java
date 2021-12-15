package com.example.test.server.api_server.controller;

import com.example.test.server.api_server.model.TodoList;
import com.example.test.server.api_server.model.common.ResultMsg;
import com.example.test.server.api_server.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping(value = "/member/todo_del/{title}")
    public @ResponseBody ResultMsg<String> listDel(@PathVariable ("title") String title) {
        int numberDel = userService.delList(title);
        if(numberDel == 0){
            return new ResultMsg<String>(false, "지울 정보를 찾을 수 없음.");
        }
        return new ResultMsg<String>(true, "삭제 완료");
    }
}
