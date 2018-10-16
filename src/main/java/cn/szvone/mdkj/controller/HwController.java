package cn.szvone.mdkj.controller;

import cn.szvone.mdkj.dto.CommonRes;
import cn.szvone.mdkj.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hw")
public class HwController {

    @Autowired
    private TagService tagService;


    @RequestMapping("/setGoodsInfo")
    public CommonRes setGoodsInfo(String mid,String sids,String sn,String info){
        return tagService.setGoodsInfo(mid, sids, sn, info);
    }

    @RequestMapping("/setAreaInfo")
    public CommonRes setAreaInfo(String mid,String sids){

        return tagService.setAreaInfo(mid,sids);
    }

    @RequestMapping("/setSold")
    public CommonRes setSold(String sid){

        return tagService.setSold(sid);
    }
}
