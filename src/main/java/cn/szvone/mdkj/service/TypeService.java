package cn.szvone.mdkj.service;

import cn.szvone.mdkj.dao.TypeDAO;
import cn.szvone.mdkj.dto.CommonRes;
import cn.szvone.mdkj.entity.Type;
import cn.szvone.mdkj.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {
    @Autowired
    private TypeDAO typeDAO;


    public CommonRes addType(String name,String statement){

        Type type = new Type();
        type.setName(name);
        type.setStatement(statement);
        int row = typeDAO.insert(type);

        if (row != 1){
            return ResultUtil.error(-1,"操作失败");
        }
        return ResultUtil.success();
    }


    public CommonRes delType(int id){

        int row = typeDAO.delete(id);
        if (row != 1){
            return ResultUtil.error(-1,"操作失败");
        }

        return ResultUtil.success();
    }


    public CommonRes getTypes(){

        List<Type> types = typeDAO.findAll();

        return ResultUtil.success(types);
    }

    public CommonRes editType(int id,String name,String statement){

        Type type = new Type();
        type.setName(name);
        type.setStatement(statement);
        type.setId(id);
        int row = typeDAO.updata(type);
        if (row != 1){
            return ResultUtil.error(-1,"操作失败");
        }

        return ResultUtil.success();
    }
}
