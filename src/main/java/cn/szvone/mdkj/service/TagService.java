package cn.szvone.mdkj.service;

import cn.szvone.mdkj.dao.*;
import cn.szvone.mdkj.dto.CommonRes;
import cn.szvone.mdkj.entity.Node;
import cn.szvone.mdkj.entity.Tag;
import cn.szvone.mdkj.entity.TagHistory;
import cn.szvone.mdkj.entity.TagInfo;
import cn.szvone.mdkj.utils.AttentionUtil;
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
    private TagInfoDAO tagInfoDAO;
    @Autowired
    private AttentionDAO attentionDAO;
    @Autowired
    private NodeDAO nodeDAO;
    @Autowired
    private TagHistoryDAO tagHistoryDAO;

    public CommonRes setTag(String sids){
        int res = 0;
        String[] sid_sz = sids.split(",");
        for (String sid:sid_sz){
            Tag tag = new Tag();
            tag.setMid(-1);
            tag.setNowmid(-1);
            tag.setSid(sid);
            tag.setInfoid(-1);
            tag.setStatus(1);
            tag.setCreateDate(new Date());
            tag.setUpdateDate(new Date());

            res += tagDAO.insert(tag);
        }



        return ResultUtil.success(res);
    }


    //重要逻辑代码  入区报警
    public CommonRes setAreaInfo(int mid,String sids){

        String[] sid_sz = sids.split(",");
        Node node = nodeDAO.findById(mid);

        int res = 0;
        for (String sid:sid_sz){
            res += tagDAO.setNowMid(mid,new Date(),sid);

            TagInfo tagInfo = tagInfoDAO.findBySid(sid);
            //入区报警
            String inMids = tagInfo.getInarea();
            String[] tmp = inMids.split(",");
            for (String inMid:tmp) {
                if (inMid.equals(String.valueOf(mid))){
                    // TODO: 2018/11/18 创建入区报警
                    attentionDAO.insert(AttentionUtil.in(sid,node.getStatement()));
                }
            }

            // 插入到历史表中
            TagHistory t = new TagHistory();
            t.setMid(String.valueOf(mid));
            t.setSid(sid);
            t.setUpdateDate(new Date());
            tagHistoryDAO.setTagHistory(t);
        }


        return ResultUtil.success(res);
    }

    //离区报警
    public CommonRes setChange(int mid,String sid){
        Node node = nodeDAO.findById(mid);
        TagInfo tagInfo = tagInfoDAO.findBySid(sid);
        String outMids = tagInfo.getOutarea();
        String[] tmp1 = outMids.split(",");
        for (String outMid:tmp1) {
            if (outMid.equals(String.valueOf(mid))){
                // TODO: 2018/11/18 创建离区报警
                attentionDAO.insert(AttentionUtil.out(sid,node.getStatement()));
            }
        }
        return ResultUtil.success();
    }


    public CommonRes getAreaTag(String mid) {
        List<Tag> tags = tagDAO.findByMid4(mid);
        return ResultUtil.success(tags);
    }

    public CommonRes getTheTag(String sid) {
        Tag tag = tagDAO.findBySid(sid);
        return ResultUtil.success(tag);
    }

}
