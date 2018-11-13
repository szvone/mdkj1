package cn.szvone.mdkj.dao;

import cn.szvone.mdkj.entity.TagInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TagInfoDAO {
    @Insert({ "insert into tag_info(name, uid, info, typeid, inarea, outarea) values(#{name}, #{uid}, #{info}, #{typeid}, #{inarea}, #{outarea})" })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(TagInfo tagInfo);

    @Update("update tag_info set name = #{name},uid = #{uid},info = #{info},typeid = #{typeid},inarea = #{inarea},outarea = #{outarea} where id = #{id}")
    int updata(TagInfo tagInfo);

    @Delete("delete from tag_info where id=#{id}")
    int delete(int id);

    @Select("select * from tag_info where id=#{id}")
    TagInfo findById(int id);
}
