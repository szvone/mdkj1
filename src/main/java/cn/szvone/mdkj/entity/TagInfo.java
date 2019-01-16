package cn.szvone.mdkj.entity;


public class TagInfo {

  private long id;
  private String name;
  private long uid;
  private String info;
  private long typeid;
  private String inarea;
  private String outarea;
  private String sid;
  private String timeout;
  private String share;
  private String mid;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public String getSid() {
        return sid;
      }

  public void setSid(String sid) {
    this.sid = sid;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getUid() {
    return uid;
  }

  public void setUid(long uid) {
    this.uid = uid;
  }


  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }


  public long getTypeid() {
    return typeid;
  }

  public void setTypeid(long typeid) {
    this.typeid = typeid;
  }


  public String getInarea() {
    return inarea;
  }

  public void setInarea(String inarea) {
    this.inarea = inarea;
  }


  public String getOutarea() {
    return outarea;
  }

  public void setOutarea(String outarea) {
    this.outarea = outarea;
  }

}
