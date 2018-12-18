package cn.szvone.mdkj.service;

import cn.szvone.mdkj.dao.TagDAO;
import cn.szvone.mdkj.dao.TagInfoDAO;
import cn.szvone.mdkj.dto.CommonRes;
import cn.szvone.mdkj.entity.Tag;
import cn.szvone.mdkj.entity.TagInfo;
import cn.szvone.mdkj.entity.User;
import cn.szvone.mdkj.execptions.AuthException;
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


    public CommonRes addTagInfo(String tagId, TagInfo tagInfo,int uid){
        Tag tag = tagDAO.findBySid(tagId);
        if(tag==null) {
            return ResultUtil.error(-1,"标签不存在");
        }
        if (tag.getInfoid()>0){
            return ResultUtil.error(-1,"该标签已被写码");
        }

        tagInfo.setUid(uid);
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


    public CommonRes getTagInfo(int id,int uid){

        TagInfo tagInfo = tagInfoDAO.findByIdAndUid(id,uid);

        return ResultUtil.success(tagInfo);
    }


    public CommonRes getMyTagInfo(int page, int limit, User u){
        List<TagInfo> tagInfos;
        if (u.getType()==1){
            tagInfos = tagInfoDAO.getTagInfoListAll((page-1)*limit,limit);
        }else{
            tagInfos = tagInfoDAO.getTagInfoList((page-1)*limit,limit,u.getId());
        }

        return ResultUtil.success(tagInfos);

    }


    public CommonRes editTagInfo(TagInfo tagInfo,int uid){
        TagInfo tagInfo1 = tagInfoDAO.findById((int)tagInfo.getId());
        if (tagInfo1.getUid()!=uid){
            throw new AuthException("权限不足");
        }
        int row = tagInfoDAO.updata(tagInfo);

        if (row == 0){
            return ResultUtil.error(-1,"操作失败");
        }
        return ResultUtil.success();
    }


    public CommonRes toShare(String sid, String toUid,int meuid){
        TagInfo tagInfo = tagInfoDAO.findBySid(sid);
        if (tagInfo.getUid()!=meuid){
            throw new AuthException("权限不足");
        }
        int re = tagInfoDAO.updateShare(sid, toUid);
        return ResultUtil.success(re);
    }


    public CommonRes getShareList(int uid){
        List<TagInfo> list = tagInfoDAO.getUserShare(Long.valueOf(uid));
        return ResultUtil.success(list);
    }

}
