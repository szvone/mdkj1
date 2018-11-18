package cn.szvone.mdkj.dao;

import cn.szvone.mdkj.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDAO {
    @Select("select * from user where username = #{username}")
    User find(@Param("username")String username);

    @Delete("delete from user where id = #{id}")
    int del(@Param("id") int id);

    @Insert({ "insert into user(username, password, type, status, statement) values(#{username}, #{password}, #{type}, #{status}, #{statement})" })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(User user);

    @Select("select * from user limit ${limit},${size}")
    List<User> getUserList(@Param("limit") int limit, @Param("size") int size);

    @Update("update user set username=#{username}, password=#{password}, statement=#{statement} where id=#{id}")
    int updateUser(User user);
}

