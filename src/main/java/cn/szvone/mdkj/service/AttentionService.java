package cn.szvone.mdkj.service;

import cn.szvone.mdkj.dao.AttentionDAO;
import cn.szvone.mdkj.dto.CommonRes;
import cn.szvone.mdkj.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Service
public class AttentionService {

    @Autowired
    private AttentionDAO attentionDAO;

    public CommonRes getAttentionByUid(int uid, String mid){
        if(mid.equals("") || mid==null){
            return ResultUtil.success(attentionDAO.getAttentionByUid(uid));
        } else {
            return ResultUtil.success(attentionDAO.getAttentionByUid1(uid, mid));
        }

    }
    public CommonRes getAttentionBySid(String sid,int uid){
        return ResultUtil.success(attentionDAO.getAttentionBySid(sid,uid));
    }


    public CommonRes setAttentionState(int id,int state){
        attentionDAO.updateState(id,state);
        return ResultUtil.success();
    }
}
