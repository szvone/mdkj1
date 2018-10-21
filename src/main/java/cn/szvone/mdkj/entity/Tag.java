package cn.szvone.mdkj.entity;

import java.util.Date;

public class Tag {
    private int id;
    private int mid;
    private int nowmid;
    private String sid;
    private int shopid;
    private int status;
    private Date createDate;
    private Date updateDate;

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", mid=" + mid +
                ", nowmid=" + nowmid +
                ", sid='" + sid + '\'' +
                ", shopid=" + shopid +
                ", status=" + status +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getNowmid() {
        return nowmid;
    }

    public void setNowmid(int nowmid) {
        this.nowmid = nowmid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public int getShopid() {
        return shopid;
    }

    public void setShopid(int shopid) {
        this.shopid = shopid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
