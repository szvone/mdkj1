package cn.szvone.mdkj.dao;

import cn.szvone.mdkj.entity.Tag;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface TagDAO {

    @Select("select * from tag where id = #{id}")
    Tag findById(@Param("id")int id);

    @Select("select * from tag where mid = #{mid}")
    List<Tag> findByMid(@Param("mid")String mid);

    @Select("select * from tag where sid = #{sid}")
    Tag findBySid(@Param("sid")String sid);

    @Select("select * from tag where sn = #{sn}")
    List<Tag> findBySn(@Param("sn")String sn);

    @Insert({ "insert into tag(mid, nowmid, sid, infoid, status, createDate, updateDate) values(#{mid}, #{nowmid}, #{sid}, #{infoid}, #{status}, #{createDate}, #{updateDate})" })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Tag tag);

    @Update("update tag set nowmid = #{mid},updateDate = #{updateDate} where sid = #{sid}")
    int setNowMid(@Param("mid")int mid, @Param("updateDate")Date updateDate, @Param("sid")String sid);

    @Update("update tag set status = #{status} where sid = #{sid}")
    int setStatus(@Param("status")int status,@Param("sid")String sid);

    @Update("update tag set infoid = #{infoid} where sid = #{sid}")
    int addInfoId(@Param("sid")String sid,@Param("infoid")int infoid);


    // 查找本母机标签
    @Select("select * from tag where mid = #{mid} and nowmid = #{mid}")
    List<Tag> findByMid1(@Param("mid")String mid);

    // 查找非本母机标签
    @Select("select * from tag where mid = #{mid} and nowmid != #{mid} and nowmid != -1")
    List<Tag> findByMid2(@Param("mid")String mid);

    // 查找未扫描的标签
    @Select("select * from tag where mid = #{mid} and nowmid = -1")
    List<Tag> findByMid3(@Param("mid")String mid);

    // 查找本母机的所有标签
    @Select("select * from tag where mid = #{mid} and nowmid != -1")
    List<Tag> findByMid4(@Param("mid")String mid);

}
