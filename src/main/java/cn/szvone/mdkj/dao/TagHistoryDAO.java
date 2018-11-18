package cn.szvone.mdkj.dao;


import cn.szvone.mdkj.entity.TagHistory;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface TagHistoryDAO {

    // 通过标签id获取该标签的所有记录
    @Select("select * from tag_history where sid = #{sid}")
    List<TagHistory> getTagHistory(@Param("sid") String sid);

    // 插入标签的最新记录
    @Insert("insert into tag_history values (null, #{sid}, #{mid}, #{updateDate})")
    int setTagHistory(TagHistory tagHistory);
}
