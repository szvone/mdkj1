package cn.szvone.mdkj.controller;

import cn.szvone.mdkj.dto.CommonRes;
import cn.szvone.mdkj.entity.Node;
import cn.szvone.mdkj.entity.TagInfo;
import cn.szvone.mdkj.entity.User;
import cn.szvone.mdkj.execptions.ArgException;
import cn.szvone.mdkj.execptions.AuthException;
import cn.szvone.mdkj.service.*;
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
    private NodeService nodeService;
    @Autowired
    private TagService tagService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagInfoService tagInfoService;



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
     * todo 测试
     * 更新用户信息
     * @param username
     * @param password
     * @param bz
     * @param session
     * @return
     */
    @RequestMapping("/updateUser")
    public CommonRes updateUser(String username,String password,String bz,HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user==null){
            throw new AuthException("用户未登录");
        }
        if(username==null || username.equals("")){
            throw new ArgException("username不能为空");
        }
        if(password==null || password.equals("")){
            throw new ArgException("password不能为空");
        }
        User u = new User();
        int id = user.getId();
        u.setId(id);
        u.setPassword(password);
        u.setStatement(bz);
        u.setUsername(username);
        return userService.updateUser(u);
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
     * todo 测试
     * 更新母机信息
     * @param id
     * @param mid
     * @param statement
     * @return
     */
    @RequestMapping("/updateNode")
    public CommonRes updateNode(int id, String mid, String statement){
        if(mid==null || mid.equals("")){
            throw new ArgException("mid不能为空");
        }
        if(statement==null || statement.equals("")){
            throw new ArgException("statement不能为空");
        }
        String val = ""+id;
        if(val==null || val.equals("")) {
            throw new ArgException("id不能为空");
        }
        try{
            id = Integer.valueOf(id);
        } catch (Exception e) {
            throw new ArgException("id类型参数错误");
        }
        Node node = new Node();
        node.setId(id);
        node.setMid(mid);
        node.setStatement(statement);
        return nodeService.updateNode(node);
    }

    /**
     * 删除母机
     * todo 测试
     * @param id
     * @return
     */
    @RequestMapping("/deleteNode")
    public CommonRes deleteNode(int id){
        String val = ""+id;
        if(val==null || val.equals("")) {
            throw new ArgException("id不能为空");
        }
        try{
            id = Integer.valueOf(id);
        } catch (Exception e) {
            throw new ArgException("id类型参数错误");
        }
        return nodeService.deleteNode(id);
    }






    /**
     * 增加分类
     * @param name      分类名
     * @param statement 分类备注
     * @return
     */
    @RequestMapping("/addType")
    public CommonRes addType(String name,String statement){
        return typeService.addType(name,statement);
    }

    /**
     * 删除分类
     * @param id 分类ID
     * @return
     */
    @RequestMapping("/delType")
    public CommonRes delType(int id){
        return typeService.delType(id);
    }

    /**
     * 拉取分类列表
     * @return
     */
    @RequestMapping("/getTypes")
    public CommonRes getTypes(){
        return typeService.getTypes();
    }

    /**
     * 编辑分类
     * @param id        分类ID
     * @param name      分类名
     * @param statement 分类简介
     * @return
     */
    @RequestMapping("/editType")
    public CommonRes editType(int id,String name,String statement){
        return typeService.editType(id,name,statement);
    }






    /**
     * 扫码设置标签信息
     * @param tagid      标签ID
     * @param tagInfo    标签信息
     * @return
     */
    @RequestMapping("/addTagInfo")
    public CommonRes addTagInfo(int tagid, TagInfo tagInfo){
        return tagInfoService.addTagInfo(tagid,tagInfo);
    }

    /**
     * 删除标签信息
     * @param id 分类ID
     * @return
     */
    @RequestMapping("/delTagInfo")
    public CommonRes delTagInfo(int id){
        return ResultUtil.error(-1,"标签信息不可删除");
        //return tagInfoService.delTagInfo(id);
    }

    /**
     * 拉取标签信息
     * @param tagid 标签id
     * @return
     */
    @RequestMapping("/getTagInfo")
    public CommonRes getTagInfo(int tagid){
        return tagInfoService.getTagInfo(tagid);
    }

    /**
     * 编辑标签信息
     * @param tagInfo    标签信息
     * @return
     */
    @RequestMapping("/editTagInfo")
    public CommonRes editTagInfo(TagInfo tagInfo){
        return tagInfoService.editTagInfo(tagInfo);
    }






    // 获取本母机下的所有正常标签
    @RequestMapping("/areaInfo")
    public CommonRes getAreaTag(String mid) {
        if (mid == null || mid.equals("")){
            throw new ArgException("母机id不能为空");
        }
        return tagService.getAreaTag(mid);
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
