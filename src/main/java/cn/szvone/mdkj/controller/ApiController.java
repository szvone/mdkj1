package cn.szvone.mdkj.controller;

import cn.szvone.mdkj.dto.CommonRes;
import cn.szvone.mdkj.execptions.ArgException;
import cn.szvone.mdkj.execptions.AuthException;
import cn.szvone.mdkj.service.UserService;
import cn.szvone.mdkj.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private UserService userService;


    @RequestMapping("/register")
    public CommonRes register(String username,String password,String bz){
        if (username.equals("") || username == null){
            throw new ArgException("用户名不能为空");
        }
        if (password.equals("") || password == null){
            throw new ArgException("密码不能为空");
        }
        if (bz.equals("") || bz == null){
            throw new ArgException("备注不能为空");
        }
        return userService.register(username,password,bz);
    }

    @RequestMapping("/login")
    public CommonRes login(String username,String password){
        if (username.equals("") || username == null){
            throw new ArgException("用户名不能为空");
        }
        if (password.equals("") || password == null){
            throw new ArgException("密码不能为空");
        }
        return userService.login(username,password);

    }
}
