package cn.szvone.mdkj.entity;

public class Configure {

    private int id;
    private String vkey;
    private String vvalue;

    @Override
    public String toString() {
        return "Configure{" +
                "id=" + id +
                ", vkey='" + vkey + '\'' +
                ", vvalue='" + vvalue + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVkey() {
        return vkey;
    }

    public void setVkey(String vkey) {
        this.vkey = vkey;
    }

    public String getVvalue() {
        return vvalue;
    }

    public void setVvalue(String vvalue) {
        this.vvalue = vvalue;
    }
}
