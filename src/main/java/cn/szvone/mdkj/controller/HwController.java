package cn.szvone.mdkj.controller;

import cn.szvone.mdkj.dto.CommonRes;
import cn.szvone.mdkj.execptions.ArgException;
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
        String val1 = mid + "";
        String val2 = shopid + "";
        if(val1 == null || "".equals(val1)){
            throw new ArgException("mid不能为空");
        }
        if(val2 == null || "".equals(val2)){
            throw new ArgException("shopid不能为空");
        }
        if(sids == null || "".equals(sids)){
            throw new ArgException("sids不能为空");
        }
        try{
            mid = Integer.valueOf(mid);
        } catch (Exception e){
            throw new ArgException("mid参数类型出错");
        }
        try{
            shopid = Integer.valueOf(shopid);
        } catch (Exception e){
            throw new ArgException("shopid参数类型出错");
        }
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
        String val1 = mid + "";
        if(val1 == null || "".equals(val1)){
            throw new ArgException("mid不能为空");
        }
        if(sids == null || "".equals(sids)){
            throw new ArgException("sids不能为空");
        }
        try{
            mid = Integer.valueOf(mid);
        } catch (Exception e){
            throw new ArgException("mid参数类型出错");
        }

        return tagService.setAreaInfo(mid,sids);
    }

    /**
     * 收银台，标记标签被卖出
     * @param sid 子机ID
     * @return
     */
    @RequestMapping("/setSales")
    public CommonRes setSales(String sid){
        if(sid==null || "".equals(sid)) {
            throw new ArgException("sid不能为空");
        }
        return tagService.setSales(sid);
    }
}
