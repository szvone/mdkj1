package cn.szvone.mdkj.dao;

import cn.szvone.mdkj.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDAO {

    @Select("select * from user where username = #{username}")
    User find(@Param("username")String username);


    @Insert({ "insert into user(username, password, type, status, statement) values(#{username}, #{password}, #{type}, #{status}, #{statement})" })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(User user);
}

