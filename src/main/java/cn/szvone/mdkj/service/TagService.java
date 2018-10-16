package cn.szvone.mdkj.service;

import cn.szvone.mdkj.dao.TagDAO;
import cn.szvone.mdkj.dto.CommonRes;
import cn.szvone.mdkj.entity.Tag;
import cn.szvone.mdkj.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TagService {
    @Autowired
    private TagDAO tagDAO;

    public CommonRes setGoodsInfo(String mid,String sids,String sn,String info){
        int res = 0;
        String[] sid_sz = sids.split(",");
        for (String sid:sid_sz){
            Tag tag = new Tag();
            tag.setMid(mid);
            tag.setNowmid("vone");
            tag.setSid(sid);
            tag.setSn(sn);
            tag.setInfo(info);
            tag.setStatus(1);
            tag.setCreateDate(new Date());
            tag.setUpdateDate(new Date());

            res += tagDAO.insert(tag);
        }

        return ResultUtil.success(res);
    }

    public CommonRes setAreaInfo(String mid,String sids){

        String[] sid_sz = sids.split(",");
        int res = 0;
        for (String sid:sid_sz){
            res += tagDAO.setNowMid(mid,new Date(),sid);
        }

        return ResultUtil.success(res);
    }

    public CommonRes setSold(String sid){

        int res = tagDAO.setStatus(0,sid);

        return ResultUtil.success(res);
    }


}
