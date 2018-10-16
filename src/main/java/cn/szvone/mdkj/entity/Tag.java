package cn.szvone.mdkj.entity;

import java.util.Date;

public class Tag {
    private int id;
    private String mid;
    private String nowmid;
    private String sid;
    private String sn;
    private String info;
    private int status;
    private Date createDate;
    private Date updateDate;

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", mid='" + mid + '\'' +
                ", nowmid='" + nowmid + '\'' +
                ", sid='" + sid + '\'' +
                ", sn='" + sn + '\'' +
                ", info='" + info + '\'' +
                ", status=" + status +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }

    public String getNowmid() {
        return nowmid;
    }

    public void setNowmid(String nowmid) {
        this.nowmid = nowmid;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
