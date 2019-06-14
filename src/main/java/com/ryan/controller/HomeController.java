package com.ryan.controller;

import com.ryan.domain.User;
import com.ryan.service.UserService;
import io.swagger.annotations.*;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Date : 2019:06:14
 * @Author : Lilanzhou
 * 说明 :
 */
@RestController
@Api(value="用户信息Api",description="用户信息Api List")
@RequestMapping("/home")
public class HomeController {

    @Autowired
    UserService userService;
    @ApiOperation("添加用户")
    //@ApiImplicitParam(name = "user",value = "添加对象",dataType ="User",required = true)
    @PostMapping("/add/{id}/{username}/{password}/")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "添加成功")})
    public ResponseEntity<Void> index (@PathVariable Integer  id,
                                       @PathVariable String  username,
                                       @PathVariable String  password){

            userService.insert(id,username,password);
            return new ResponseEntity<Void>(HttpStatus.OK);

    }


    @ApiOperation(value = "根据id删除用户")
    @DeleteMapping(value = "/del/{index}/")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "删除成功"),
            @ApiResponse(code = 204,message = "删除失败")})
    public ResponseEntity<Void> delete(@PathVariable Integer index) {
        int i = userService.delete(index);
        if(i==1){
            return new ResponseEntity<Void>(HttpStatus.OK);
        }else {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
    }



    @ApiOperation(value = "根据id更新用户")
    @PutMapping(value = "/update/{index}/{username}/{password}")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "更新成功"),
            @ApiResponse(code = 204,message = "更新失败")})
    public ResponseEntity<Void> update(@PathVariable Integer index,
                                       @PathVariable String username,
                                       @PathVariable String password) {
        int i = userService.update(index,username,password);

        if(i==1){
            return new ResponseEntity<Void>(HttpStatus.OK);
        }else {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
    }



    @ApiOperation(value ="根据姓名查询用户")
    @GetMapping(value = "/query/{username}")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "查询成功"),
            @ApiResponse(code = 204,message = "查询失败")})
    public ResponseEntity<User> query(@PathVariable String username) {
        User user= userService.query(username);

        if(user!=null){
            return new ResponseEntity<User>( user,HttpStatus.OK);
        }else {
            return new ResponseEntity<User>( HttpStatus.NO_CONTENT);
        }
    }
}
