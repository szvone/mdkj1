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

    /**
     * 录入端，上传标签数据
     * @param mid       母机ID
     * @param sids      子机ID
     * @param shopid    商品ID
     * @return
     */
    @RequestMapping("/setGoodsInfo")
    public CommonRes setGoodsInfo(int mid,String sids,int shopid){
        return tagService.setGoodsInfo(mid, sids, shopid);
    }

    /**
     * 扫描机，上传扫描到的标签数据到服务器
     * @param mid   母机ID
     * @param sids  扫描到的子机ID
     * @return
     */
    @RequestMapping("/setAreaInfo")
    public CommonRes setAreaInfo(int mid,String sids){

        return tagService.setAreaInfo(mid,sids);
    }

    /**
     * 收银台，标记标签被卖出
     * @param sid 子机ID
     * @return
     */
    @RequestMapping("/setSales")
    public CommonRes setSales(String sid){
        return tagService.setSales(sid);
    }
}
