package cn.szvone.mdkj.controller;

import cn.szvone.mdkj.dto.CommonRes;
import cn.szvone.mdkj.entity.User;
import cn.szvone.mdkj.execptions.ArgException;
import cn.szvone.mdkj.execptions.AuthException;
import cn.szvone.mdkj.service.AdminService;
import cn.szvone.mdkj.service.NodeService;
import cn.szvone.mdkj.service.ShopService;
import cn.szvone.mdkj.service.UserService;
import cn.szvone.mdkj.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/sw")
public class SwController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private ShopService shopService;
    @Autowired
    private NodeService nodeService;



    /**
     * 后台用户登录
     * @param username  账号
     * @param password  密码
     * @return
     */
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

    /**
     * 获取当前登录用户的个人信息
     * @return
     */
    @RequestMapping("/getMe")
    public CommonRes getMe(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user==null){
            throw new AuthException("用户未登录");
        }
        return ResultUtil.success(user);
    }

    /**
     * 退出登录
     * @return
     */
    @RequestMapping("/loginOut")
    public CommonRes loginOut(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user==null){
            throw new AuthException("用户未登录");
        }

        session.removeAttribute("user");
        return ResultUtil.success();
    }





    /**
     * 添加用户
     * @param username  账号
     * @param password  密码
     * @param bz        备注
     * @return
     */
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


    /**
     * 删除用户
     * @param id    需要删除的用户ID
     * @return
     */
    @RequestMapping("/delUser")
    public CommonRes delUser(int id){
        try{
            String val = id +"";
            if(val == null || "".equals(val)){
                throw new ArgException("id不能为空");
            }
            id = Integer.valueOf(id);
        } catch (Exception e){
            throw new ArgException("id参数类型出错");
        }
        return userService.delUser(id);
    }


    /**
     * 获取用户列表
     * @param page  获取第几页
     * @param limit 一页获取几个
     * @return
     */
    @RequestMapping("/getUserList")
    public CommonRes getUserList(int page,int limit){
        String val1 = page + "";
        String val2 = limit + "";
        if(val1 == null || "".equals(val1)){
            throw new ArgException("page不能为空");
        }
        if(val2 == null || "".equals(val2)){
            throw new ArgException("limit不能为空");
        }
        try{
           page = Integer.valueOf(page);
        } catch (Exception e){
            throw new ArgException("page参数类型出错");
        }
        try{
            limit = Integer.valueOf(limit);
        } catch (Exception e){
            throw new ArgException("limit参数类型出错");
        }

        return userService.getUserList(page,limit);
    }





    /**
     * 添加母机
     * @param mid       母机编号
     * @param statement 母机区域
     * @return
     */
    @RequestMapping("/addNode")
    public CommonRes addNode(String mid,String statement){
        if(mid==null || mid.equals("")){
            throw new ArgException("mid不能为空");
        }
        if(statement==null || statement.equals("")){
            throw new ArgException("statement不能为空");
        }
        return nodeService.addNode(mid,statement);

    }
    /**
     * 检索母机数据
     * @param name  母机所属区域关键字
     * @return
     */
    @RequestMapping("/getNodes")
    public CommonRes getNodes(String name){
        return nodeService.getNodes(name);
    }





    /**
     * 添加商品
     * @param name  商品标题
     * @param money 商品售价
     * @param sn    商品条形码
     * @param info  商品的其他信息，为json字符串
     * @return
     */
    @RequestMapping("/addShop")
    public CommonRes addShop(String name,double money,String sn,String info){
        if (name == null || name.equals("")){
            throw new ArgException("商品名不能为空");
        }
        if (money<0){
            throw new ArgException("商品售价错误");
        }
        if (sn == null || sn.equals("")){
            throw new ArgException("商品条形码不能为空");
        }

        shopService.addShop(name, money, sn, info);

        return ResultUtil.success();
    }

    /**
     * 删除商品
     * @param id    需要删除的商品id
     * @return
     */
    @RequestMapping("/delShop")
    public CommonRes delShop(int id){
        try{
            String val = id + "";
            if(val == null || val.equals("")) {
                throw new ArgException("id不能为空");
            }
            id = Integer.valueOf(id);
        } catch (Exception e) {
            throw new ArgException("id参数类型错误");
        }
        return shopService.delShop(id);
    }

    /**
     * 获取商品列表
     * @param page      获取第几页
     * @param limit     一页获取多少个
     * @return
     */
    @RequestMapping("/getShopList")
    public CommonRes getShopList(int page,int limit){
        String val1 = page + "";
        String val2 = limit + "";
        if(val1 == null || "".equals(val1)){
            throw new ArgException("page不能为空");
        }
        if(val2 == null || "".equals(val2)){
            throw new ArgException("limit不能为空");
        }
        try{
            page = Integer.valueOf(page);
        } catch (Exception e){
            throw new ArgException("page参数类型出错");
        }
        try{
            limit = Integer.valueOf(limit);
        } catch (Exception e){
            throw new ArgException("limit参数类型出错");
        }
        return shopService.getShopList(page,limit);
    }

    /**
     * 检索商品数据
     * @param name 商品标题关键字
     * @return
     */
    @RequestMapping("/getShops")
    public CommonRes getShops(String name){
        if (name == null || name.equals("")){
            throw new ArgException("name参数不能为空");
        }
        return shopService.getShops(name);
    }








    //拉取首页状态信息  （暂未写逻辑）
    @RequestMapping("/getState")
    public CommonRes getState(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user==null){
            throw new AuthException("用户未登录");
        }
        CommonRes res = adminService.getState();
        return res;
    }

    //拉取母机状态信息  （暂未写逻辑）
    @RequestMapping("/getMidInfo")
    public CommonRes getMidInfo(HttpSession session,String mid){
        User user = (User) session.getAttribute("user");
        if (user==null){
            throw new AuthException("用户未登录");
        }
        CommonRes res = adminService.getMidInfo(mid);
        return res;
    }

}
