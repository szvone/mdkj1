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
     * @param sids      子机ID
     * @return
     */
    @RequestMapping("/setTag")
    public CommonRes setTag(String sids){
        if(sids == null || "".equals(sids)){
            throw new ArgException("sids不能为空");
        }

        return tagService.setTag( sids);
    }



    /**
     * 发现标签不见了，上传数据
     * @param mid   母机的ID
     * @param sid   标签id
     * @return
     */
    @RequestMapping("/setChange")
    public CommonRes setChange(String mid,String sid){
        if(sid == null || "".equals(sid)){
            throw new ArgException("sid不能为空");
        }

        return tagService.setChange(mid, sid);
    }



    /**
     * 扫描机，上传扫描到的标签数据到服务器
     * @param mid   母机ID
     * @param sids  扫描到的子机ID
     * @return
     */
    @RequestMapping("/setAreaInfo")
    public CommonRes setAreaInfo(String mid,String sids){
        if(mid == null || "".equals(mid)){
            throw new ArgException("mid不能为空");
        }
        if(sids == null || "".equals(sids)){
            throw new ArgException("sids不能为空");
        }

        return tagService.setAreaInfo(mid,sids);
    }

}
