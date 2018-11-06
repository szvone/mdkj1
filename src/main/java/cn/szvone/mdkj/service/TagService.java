package cn.szvone.mdkj.service;

import cn.szvone.mdkj.dao.ShopDAO;
import cn.szvone.mdkj.dao.TagDAO;
import cn.szvone.mdkj.dto.CommonRes;
import cn.szvone.mdkj.entity.Tag;
import cn.szvone.mdkj.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagDAO tagDAO;
    @Autowired
    private ShopDAO shopDAO;


    public CommonRes setGoodsInfo(int mid,String sids,int shopid){
        int res = 0;
        String[] sid_sz = sids.split(",");
        for (String sid:sid_sz){
            Tag tag = new Tag();
            tag.setMid(mid);
            tag.setNowmid(-1);
            tag.setSid(sid);
            tag.setShopid(shopid);
            tag.setStatus(1);
            tag.setCreateDate(new Date());
            tag.setUpdateDate(new Date());

            res += tagDAO.insert(tag);
        }

        shopDAO.setStock(shopid,res);


        return ResultUtil.success(res);
    }

    public CommonRes setAreaInfo(int mid,String sids){

        String[] sid_sz = sids.split(",");
        int res = 0;
        for (String sid:sid_sz){
            res += tagDAO.setNowMid(mid,new Date(),sid);
        }

        return ResultUtil.success(res);
    }

    public CommonRes setSales(String sid){
        Tag tag = tagDAO.findBySid(sid);

        int res = tagDAO.setStatus(0,sid);

        shopDAO.setSales(tag.getShopid(),1);

        return ResultUtil.success(res);
    }

    public CommonRes getAreaTag(String mid) {
        List<Tag> tags = tagDAO.findByMid4(mid);
        return ResultUtil.success(tags);
    }

}
