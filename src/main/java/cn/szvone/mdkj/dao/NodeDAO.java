package cn.szvone.mdkj.dao;

import cn.szvone.mdkj.entity.Node;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NodeDAO {

    @Insert({ "insert into node(mid, statement, inarea, outarea) values(#{mid}, #{statement}, #{inarea}, #{outarea})" })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Node node);

    @Select("select * from node where statement like '%${name}%' order by id desc")
    List<Node> getNodes(@Param("name") String name);

    @Update("update node set statement=#{statement}, mid=#{mid} where id=#{id}")
    int updateNode(Node node);

    @Delete("delete from node where id=#{id}")
    int deleteNode(int id);

    @Select("select * from node where id=#{id} order by id desc")
    Node findById(int id);

    @Select("select * from node where mid=#{mid}  order by id desc")
    Node findByMid(String id);
}
