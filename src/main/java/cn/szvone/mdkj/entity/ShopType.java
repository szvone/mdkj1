package cn.szvone.mdkj.entity;

public class ShopType {
    private int id;
    private int parentid;  //0代表根节点 不是
    private int isparent;   //1代表是最底层 0代表还有下层
    private String name;
}
