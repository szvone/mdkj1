package cn.szvone.mdkj.controller;

import cn.szvone.mdkj.dto.CommonRes;
import cn.szvone.mdkj.entity.User;
import cn.szvone.mdkj.execptions.ArgException;
import cn.szvone.mdkj.execptions.AuthException;
import cn.szvone.mdkj.service.AdminService;
import cn.szvone.mdkj.service.UserService;
import cn.szvone.mdkj.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;


    @RequestMapping("/addUser")
    public CommonRes addUser(String username,String password,String bz, HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user==null){
            throw new AuthException("用户未登录");
        }

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
    public CommonRes login(String username, String password, HttpSession session){


        if (username.equals("") || username == null){
            throw new ArgException("用户名不能为空");
        }
        if (password.equals("") || password == null){
            throw new ArgException("密码不能为空");
        }
        CommonRes res = userService.login(username,password);
        session.setAttribute("user",res.getData());
        return res;
    }

    @RequestMapping("/getMe")
    public CommonRes getMe(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user==null){
            throw new AuthException("用户未登录");
        }
        return ResultUtil.success(user);
    }

    @RequestMapping("/loginOut")
    public CommonRes loginOut(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user==null){
            throw new AuthException("用户未登录");
        }

        session.removeAttribute("user");
        return ResultUtil.success();
    }


    @RequestMapping("/getState")
    public CommonRes getState(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user==null){
            throw new AuthException("用户未登录");
        }

        CommonRes res = adminService.getState();
        res.setCode(0);
        return res;
    }

    @RequestMapping("/getMidInfo")
    public CommonRes getMidInfo(HttpSession session,String mid){
        User user = (User) session.getAttribute("user");
        if (user==null){
            throw new AuthException("用户未登录");
        }
        CommonRes res = adminService.getMidInfo(mid);
        res.setCode(0);
        return res;
    }


}
