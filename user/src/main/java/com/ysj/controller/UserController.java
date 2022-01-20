package com.ysj.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ysj.entity.User;
import com.ysj.service.UserService;
import com.ysj.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author ysj
 * @since 2021-11-28
 */
@RestController
@RequestMapping("/user")
//@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/list")
    public List<User> list(){
        return this.userService.list();
    }


    @PostMapping("/login")
    public Map<String,Object> login(@RequestBody User user){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        List<User> res = userService.list(queryWrapper);
        if(res.size() > 0){
            redisTemplate.opsForValue().setIfAbsent(user.getUserNickname(),user);
            Map<String,Object> query = new HashMap<>();
            query.put("user",res.get(0));
            query.put("token",JWTUtils.createJWT());
            return query;
        }
        return null;
    }

}

