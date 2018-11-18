package cn.szvone.mdkj.service;

import cn.szvone.mdkj.dao.TagHistoryDAO;
import cn.szvone.mdkj.dao.TagInfoDAO;
import cn.szvone.mdkj.dto.CommonRes;
import cn.szvone.mdkj.entity.TagHistory;
import cn.szvone.mdkj.entity.TagInfo;
import cn.szvone.mdkj.execptions.AuthException;
import cn.szvone.mdkj.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TagHistoryService {

    @Autowired
    private TagHistoryDAO tagHistoryDAO;
    @Autowired
    private TagInfoDAO tagInfoDAO;


    public CommonRes getTagHistory(String sid,int meid) {
        TagInfo tagInfo = tagInfoDAO.findBySid(sid);
        if (tagInfo.getUid()!=meid){
            throw new AuthException("权限不足");
        }
        List<TagHistory> list = tagHistoryDAO.getTagHistory(sid);
        return ResultUtil.success(list);
    }

    public CommonRes setTagHistory(TagHistory tagHistory) {
        int result = tagHistoryDAO.setTagHistory(tagHistory);
        return ResultUtil.success(result);
    }
}
