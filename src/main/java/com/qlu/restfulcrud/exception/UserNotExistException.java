package com.qlu.restfulcrud.exception;

/**
 * @author jiajinshuo
 * @create 2020-02-10 15:45
 */
public class UserNotExistException extends RuntimeException {

    public UserNotExistException(){
        super("用户不存在");
    }
}
