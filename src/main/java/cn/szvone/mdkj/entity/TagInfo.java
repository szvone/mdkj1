package cn.szvone.mdkj.entity;


public class TagInfo {

  private long id;
  private String name;
  private long uid;
  private String sn;
  private String info;
  private long typeid;
  private String inarea;
  private String outarea;


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
