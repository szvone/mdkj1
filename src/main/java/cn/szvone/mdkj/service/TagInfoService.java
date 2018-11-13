package cn.szvone.mdkj.service;

import cn.szvone.mdkj.dao.TagDAO;
import cn.szvone.mdkj.dao.TagInfoDAO;
import cn.szvone.mdkj.dto.CommonRes;
import cn.szvone.mdkj.entity.Tag;
import cn.szvone.mdkj.entity.TagInfo;
import cn.szvone.mdkj.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagInfoService {
    @Autowired
    private TagInfoDAO tagInfoDAO;
    @Autowired
    private TagDAO tagDAO;


    public CommonRes addTagInfo(int tagId, TagInfo tagInfo){
        Tag tag = tagDAO.findById(tagId);
        if (tag.getInfoid()>0){
            return ResultUtil.error(-1,"该标签已被写码");
        }

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

}
