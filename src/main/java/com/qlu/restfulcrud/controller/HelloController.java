package com.qlu.restfulcrud.controller;

import com.qlu.restfulcrud.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * @author jiajinshuo
 * @create 2020-02-06 21:07
 */
@Controller
public class HelloController {
//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return"index";
//    }
    @ResponseBody
    @RequestMapping("/hello")
        public String hello(@RequestParam("user") String user){//从请求参数中获取值
        if(user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "hello springboot";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("tom","marry","jack"));
        return "success";
    }
}
