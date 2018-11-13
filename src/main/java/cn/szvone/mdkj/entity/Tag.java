package cn.szvone.mdkj.entity;


import java.util.Date;

public class Tag {

  private long id;
  private int mid;
  private int nowmid;
  private String sid;
  private long infoid;
  private long status;
  private Date createDate;
  private Date updateDate;


  public long getId() {
    return id;
  }

  public void setId(long id) {
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


  public long getInfoid() {
    return infoid;
  }

  public void setInfoid(long infoid) {
    this.infoid = infoid;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
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
