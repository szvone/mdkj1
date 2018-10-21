package cn.szvone.mdkj.service;

import cn.szvone.mdkj.dao.ShopDAO;
import cn.szvone.mdkj.dto.CommonRes;
import cn.szvone.mdkj.entity.Shop;
import cn.szvone.mdkj.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    @Autowired
    private ShopDAO shopDAO;


    public CommonRes addShop(String name,double money,String sn,String info){

        Shop shop = new Shop();
        shop.setName(name);
        shop.setMoney(money);
        shop.setSn(sn);
        shop.setInfo(info);
        shop.setSales(0);
        shop.setStock(0);

        int res = shopDAO.insert(shop);


        return ResultUtil.success(res);
    }


    public CommonRes getShopList(int page,int limit){
        List<Shop> shops = shopDAO.getShopList((page-1)*limit,limit);

        CommonRes res = ResultUtil.success(shops);
        return res;
    }


    public CommonRes getShops(String name){
        List<Shop> shops = shopDAO.getShops(name);

        return ResultUtil.success(shops);
    }

    public CommonRes delShop(int id){
        int i = shopDAO.del(id);

        return ResultUtil.success(i);
    }
}
