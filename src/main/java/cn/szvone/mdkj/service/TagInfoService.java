package cn.szvone.mdkj.service;

import cn.szvone.mdkj.dao.TagDAO;
import cn.szvone.mdkj.dao.TagInfoDAO;
import cn.szvone.mdkj.dto.CommonRes;
import cn.szvone.mdkj.entity.Tag;
import cn.szvone.mdkj.entity.TagInfo;
import cn.szvone.mdkj.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagInfoService {
    @Autowired
    private TagInfoDAO tagInfoDAO;
    @Autowired
    private TagDAO tagDAO;


    public CommonRes addTagInfo(String tagId, TagInfo tagInfo){
        Tag tag = tagDAO.findBySid(tagId);
        if (tag.getInfoid()>0){
            return ResultUtil.error(-1,"该标签已被写码");
        }

        // todo 从session获取用户id
        tagInfo.setUid(2);
        tagInfo.setSid(tagId);
        int row = tagInfoDAO.insert(tagInfo);
        if (row == 0){
            return ResultUtil.error(-1,"操作失败");
        }
        tagDAO.addInfoId(tagId,(int)tagInfo.getId());
        return ResultUtil.success();
    }

    public CommonRes delTagInfo(int id){
        int row = tagInfoDAO.delete(id);
        if (row == 0){
            return ResultUtil.error(-1,"操作失败");
        }
        return ResultUtil.success();

    }

    public CommonRes getTagInfo(int id){

        TagInfo tagInfo = tagInfoDAO.findById(id);

        return ResultUtil.success(tagInfo);
    }

    public CommonRes editTagInfo(TagInfo tagInfo){

        int row = tagInfoDAO.updata(tagInfo);

        if (row == 0){
            return ResultUtil.error(-1,"操作失败");
        }
        return ResultUtil.success();
    }

    public CommonRes toShare(String sid, String toUid){
        String[] uid_sz = toUid.split(",");
        String end_uid = "";
        for (String uid:uid_sz){
            end_uid += ("["+uid+"],");
        }
        int re = tagInfoDAO.updateShare(sid, end_uid);
        return ResultUtil.success(re);
    }

    public CommonRes getShareList(int uid){
        List<TagInfo> list = tagInfoDAO.getUserShare(Long.valueOf(uid));
        return ResultUtil.success(list);
    }

}
