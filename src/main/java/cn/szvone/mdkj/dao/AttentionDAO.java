package cn.szvone.mdkj.dao;

import cn.szvone.mdkj.entity.Attention;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AttentionDAO {
    @Insert({ "insert into Attention(sid, type, msg, date) values(#{sid}, #{type}, #{msg}, #{date})" })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Attention attention);

    @Select("select * from Attention where sid = #{sid}")
    List<Attention> getAttentions(@Param("sid") String sid);
}
