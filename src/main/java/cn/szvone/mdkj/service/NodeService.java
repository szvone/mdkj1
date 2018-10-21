package cn.szvone.mdkj.service;

import cn.szvone.mdkj.dao.NodeDAO;
import cn.szvone.mdkj.dto.CommonRes;
import cn.szvone.mdkj.entity.Node;
import cn.szvone.mdkj.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeService {
    @Autowired
    private NodeDAO nodeDAO;

    public CommonRes addNode(String mid,String statement){

        Node node = new Node();
        node.setMid(mid);
        node.setStatement(statement);

        int res = nodeDAO.insert(node);

        return ResultUtil.success(res);
    }

    public CommonRes getNodes(String name){

        List<Node> nodes = nodeDAO.getNodes(name);

        return ResultUtil.success(nodes);
    }
}
