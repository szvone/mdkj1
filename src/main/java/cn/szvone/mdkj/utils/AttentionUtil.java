package cn.szvone.mdkj.utils;

import cn.szvone.mdkj.entity.Attention;

import java.util.Date;

public class AttentionUtil {

    public static Attention in(String sid,String m){
        Attention attention = new Attention();
        attention.setType(1);
        attention.setSid(sid);
        attention.setMsg("【入区报警】该标签进入"+m+"区域，请知悉！");
        attention.setDate(new Date());
        return attention;
    }

    public static Attention out(String sid,String m){
        Attention attention = new Attention();
        attention.setType(2);
        attention.setSid(sid);
        attention.setMsg("【离区报警】该标签离开"+m+"区域，请知悉！");
        attention.setDate(new Date());
        return attention;
    }

}
