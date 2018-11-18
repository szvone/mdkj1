package cn.szvone.mdkj.entity;

public class Node {

    private int id;
    private String mid;
    private String statement;
    private String inarea;
    private String outarea;


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

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }
}
