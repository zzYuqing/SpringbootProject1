package com.yoyo.controller;

import com.yoyo.pojo.Emp;
import com.yoyo.pojo.Result;
import com.yoyo.service.EmpService;
import com.yoyo.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private EmpService empService;
    @PostMapping
    public Result login(@RequestBody Emp emp){
        Emp e=empService.login(emp);

        //登录成功，jwt下发令牌
        if(e!=null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id",emp.getId());
            claims.put("name",emp.getName());
            claims.put("username",emp.getUsername());
            String jwt = JwtUtils.generateJwt(claims);//此时，Jwt包含了员工信息
            return Result.success(jwt);
        }

        return  Result.error("用户名或密码输入错误");
    }


}
