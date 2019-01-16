package cn.szvone.mdkj.dao;

import cn.szvone.mdkj.entity.TagInfo;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface TagInfoDAO {
    @Insert({ "insert into tag_info(name, uid, info, typeid, inarea, outarea, sid, timeout) values(#{name}, #{uid}, #{info}, #{typeid}, #{inarea}, #{outarea}, #{sid}, #{timeout})" })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(TagInfo tagInfo);

    @Update("update tag_info set name = #{name},uid = #{uid},info = #{info},typeid = #{typeid},inarea = #{inarea},outarea = #{outarea} where id = #{id}")
    int updata(TagInfo tagInfo);

    @Delete("delete from tag_info where id=#{id}")
    int delete(int id);

    @Select("select * from tag_info where sid=#{sid} order by id desc")
    TagInfo findBySid(String sid);


    @Select("select * from tag_info where id=#{id} order by id desc")
    TagInfo findById(int id);

    @Select("select * from tag_info where id=#{id} and uid = #{uid} order by id desc")
    TagInfo findByIdAndUid(@Param("id") int id,@Param("uid") int uid);

    // 更新共享用户
    @Update("update tag_info set share=#{share} where sid=#{sid}")
    int updateShare(@Param("sid") String sid, @Param("share") String share);

    // 通过uid查询共享的标签
    @Select("select * from tag_info where share like '%[${uid}]%' order by id desc")
    List<TagInfo> getUserShare(@Param("uid") Long uid);


    @Select("select * from tag_info where uid=${uid}  order by id desc limit ${limit},${size}")
    List<TagInfo> getTagInfoList(@Param("limit") int limit, @Param("size") int size,@Param("uid")int uid);

    @Select("select * from tag_info order by id desc limit ${limit},${size}")
    List<TagInfo> getTagInfoListAll(@Param("limit") int limit, @Param("size") int size);

    @Select("select * from tag_info where name like '%${name}%' order by id desc")
    List<TagInfo> findTagInfoByName(@Param("name") String name);


    @Update("update tag_info set mid = #{mid} where sid = #{sid}")
    int setNowMid(@Param("mid")String mid, @Param("sid")String sid);


}
