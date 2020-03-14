package com.qlu.restfulcrud.controller;

import com.qlu.restfulcrud.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.event.ObjectChangeListener;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jiajinshuo
 * @create 2020-02-10 15:42
 * 自己定制json数据
 */
//异常处理器
@ResponseBody
@ControllerAdvice
public class MyExceptionController {
    @ExceptionHandler(UserNotExistException.class)
    public Map<String,Object> handlerException(Exception e){
        //浏览器和客户端都是返回的json，不能自适应
        HashMap<String, Object> map = new HashMap<>();
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        return map;

    }
}
