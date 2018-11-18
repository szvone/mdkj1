package cn.szvone.mdkj.service;

import cn.szvone.mdkj.dao.TagHistoryDAO;
import cn.szvone.mdkj.dto.CommonRes;
import cn.szvone.mdkj.entity.TagHistory;
import cn.szvone.mdkj.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TagHistoryService {

    @Autowired
    private TagHistoryDAO tagHistoryDAO;

    public CommonRes getTagHistory(String sid) {
        List<TagHistory> list = tagHistoryDAO.getTagHistory(sid);
        return ResultUtil.success(list);
    }

    public CommonRes setTagHistory(TagHistory tagHistory) {
        int result = tagHistoryDAO.setTagHistory(tagHistory);
        return ResultUtil.success(result);
    }
}
