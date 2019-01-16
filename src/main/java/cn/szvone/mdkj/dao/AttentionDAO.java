package cn.szvone.mdkj.dao;

import cn.szvone.mdkj.entity.Attention;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface AttentionDAO {
    @Insert({ "insert into Attention(sid, type, msg, date, state, uid) values(#{sid}, #{type}, #{msg}, #{date}, 0, #{uid})" })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Attention attention);

    @Select("select * from Attention where uid = #{uid} order by id desc")
    List<Attention> getAttentionByUid(@Param("uid") int uid);

    @Select("select * from Attention where sid = #{sid},uid = #{uid} order by id desc")
    List<Attention> getAttentionBySid(@Param("sid") String sid,@Param("uid") int uid);

    @Update("update Attention set state=#{state} where id=#{id}")
    int updateState(@Param("id") int id,@Param("state")int state);
}
