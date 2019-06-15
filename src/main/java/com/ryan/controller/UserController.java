package com.ryan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Date : 2019:06:15
 * @Author : Lilanzhou
 * 说明 :
 */
@Controller
public class UserController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

}
