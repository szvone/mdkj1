package cn.szvone.mdkj.entity;

public class Node {

    private int id;
    private String mid;
    private String statement;

    @Override
    public String toString() {
        return "node{" +
                "id=" + id +
                ", mid='" + mid + '\'' +
                ", statement='" + statement + '\'' +
                '}';
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
