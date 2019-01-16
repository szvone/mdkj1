package cn.szvone.mdkj.utils;

import cn.szvone.mdkj.entity.Attention;

import java.util.Date;

public class AttentionUtil {

    public static Attention in(String sid,String m,int uid){
        Attention attention = new Attention();
        attention.setType(1);
        attention.setSid(sid);
        attention.setUid(uid);
        attention.setMsg(m);
        attention.setDate(new Date());
        return attention;
    }

    public static Attention out(String sid,String m,int uid){
        Attention attention = new Attention();
        attention.setType(2);
        attention.setSid(sid);
        attention.setUid(uid);
        attention.setMsg(m);
        attention.setDate(new Date());
        return attention;
    }

    public static Attention nodein(String sid,String m,int uid){
        Attention attention = new Attention();
        attention.setType(1);
        attention.setSid(sid);
        attention.setUid(uid);
        attention.setMsg(m);
        attention.setDate(new Date());
        return attention;
    }

    public static Attention nodeout(String sid,String m,int uid){
        Attention attention = new Attention();
        attention.setType(2);
        attention.setSid(sid);
        attention.setUid(uid);
        attention.setMsg(m);
        attention.setDate(new Date());
        return attention;
    }

}
