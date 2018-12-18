package cn.szvone.mdkj.handle;


import cn.szvone.mdkj.dto.CommonRes;
import cn.szvone.mdkj.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonRes handle(Exception e){
        logger.error(e.getMessage());
        if (e.getClass().getName().indexOf("ArgException")!=-1){
            return ResultUtil.error(-1,e.getMessage());
        }
        if (e.getClass().getName().indexOf("AuthException")!=-1){
            return ResultUtil.error(-1,e.getMessage());
        }
        e.printStackTrace();
        return ResultUtil.error(500,"系统内部错误，错误类型:"+e.getClass().getName());
    }
}
