package cn.szvone.mdkj.dao;

import cn.szvone.mdkj.entity.Shop;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShopDAO {

    @Insert({ "insert into shop(name, money, sn, info, sales, stock) values(#{name}, #{money}, #{sn}, #{info}, #{sales}, #{stock})" })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Shop shop);

    @Select("select * from shop where name like '%${name}%'")
    List<Shop> getShops(@Param("name") String name);

    @Select("select * from shop limit ${limit},${size}")
    List<Shop> getShopList(@Param("limit") int limit, @Param("size") int size);

    @Delete("delete from user where id = #{id}")
    int del(@Param("id") int id);

    @Update("update shop where id = #{shopid} set sales = sales + ${i},stock = stock - ${i}")
    int setSales(@Param("shopid")int shopid, @Param("i") int i);

    @Update("update shop where id = #{shopid} set stock = stock + ${i}")
    int setStock(@Param("shopid")int shopid, @Param("i") int i);

}
