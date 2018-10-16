package cn.szvone.mdkj.service;

import cn.szvone.mdkj.dto.CommonRes;
import cn.szvone.mdkj.dto.MidInfoDto;
import cn.szvone.mdkj.dto.StateDto;
import cn.szvone.mdkj.utils.ResultUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    public CommonRes getState(){
        List<StateDto> list = new ArrayList<>();

        StateDto stateDto1 = new StateDto();
        stateDto1.setMid("测试母机A");
        stateDto1.setSidsum(10);
        stateDto1.setTrueSidSum(7);
        stateDto1.setFalseSidSum(3);
        list.add(stateDto1);

        StateDto stateDto2 = new StateDto();
        stateDto2.setMid("测试母机B");
        stateDto2.setSidsum(12);
        stateDto2.setTrueSidSum(10);
        stateDto2.setFalseSidSum(2);
        list.add(stateDto2);

        return ResultUtil.success(list);
    }

    public CommonRes getMidInfo(String mid){
        List<MidInfoDto> list = new ArrayList<>();

        MidInfoDto midInfoDto1 = new MidInfoDto();
        midInfoDto1.setMid("测试母机A");
        midInfoDto1.setSid("测试子机1");
        midInfoDto1.setSidNo("88888888");
        midInfoDto1.setSidState("正常");
        list.add(midInfoDto1);

        MidInfoDto midInfoDto2 = new MidInfoDto();
        midInfoDto2.setMid("测试母机A");
        midInfoDto2.setSid("测试子机1");
        midInfoDto2.setSidNo("88888888");
        midInfoDto2.setSidState("错位");
        list.add(midInfoDto2);

        return ResultUtil.success(list);
    }
}
