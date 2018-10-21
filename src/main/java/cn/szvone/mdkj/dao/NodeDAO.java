package cn.szvone.mdkj.dao;

import cn.szvone.mdkj.entity.Node;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NodeDAO {

    @Insert({ "insert into node(mid, statement) values(#{mid}, #{statement})" })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Node node);

    @Select("select * from node where statement like '%${name}%'")
    List<Node> getNodes(@Param("name") String name);
}
