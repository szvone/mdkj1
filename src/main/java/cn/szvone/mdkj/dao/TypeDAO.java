package cn.szvone.mdkj.dao;

import cn.szvone.mdkj.entity.Type;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TypeDAO {
    @Insert({ "insert into type(name, statement) values(#{name}, #{statement})" })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Type type);

    @Update("update type set name = #{name},statement = #{statement} where id = #{id}")
    int updata(Type type);

    @Delete("delete from type where id=#{id}")
    int delete(int id);

    @Select("select * from type")
    List<Type> findAll();
}
