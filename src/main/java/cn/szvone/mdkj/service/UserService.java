package cn.szvone.mdkj.service;

import cn.szvone.mdkj.dao.UserDAO;
import cn.szvone.mdkj.dto.CommonRes;
import cn.szvone.mdkj.entity.User;
import cn.szvone.mdkj.execptions.AuthException;
import cn.szvone.mdkj.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public CommonRes register(String username,String password,String bz){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setStatement(bz);
        user.setStatus(1);
        user.setType(1);

        int id = userDAO.insert(user);


        return ResultUtil.success(id);
    }


    public CommonRes login(String username,String password){

        User user = userDAO.find(username);

        if (user == null) {
            throw new AuthException("用户不存在");
        }
        if (!user.getPassword().equals(password)){
            throw new AuthException("密码错误");
        }
        return ResultUtil.success(user);
    }

    public CommonRes getUserList(int page,int limit){

        List<User> users = userDAO.getUserList((page-1)*limit,limit);

        return ResultUtil.success(users);
    }

    public CommonRes delUser(int id){
        int i = userDAO.del(id);

        return ResultUtil.success(i);
    }



}
