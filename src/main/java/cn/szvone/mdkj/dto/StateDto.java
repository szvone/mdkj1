package cn.szvone.mdkj.dto;

public class StateDto {
    private String mid;
    private int sidsum;
    private int falseSidSum;
    private int trueSidSum;

    @Override
    public String toString() {
        return "StateDto{" +
                "mid='" + mid + '\'' +
                ", sidsum=" + sidsum +
                ", falseSidSum=" + falseSidSum +
                ", trueSidSum=" + trueSidSum +
                '}';
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public int getSidsum() {
        return sidsum;
    }

    public void setSidsum(int sidsum) {
        this.sidsum = sidsum;
    }

    public int getFalseSidSum() {
        return falseSidSum;
    }

    public void setFalseSidSum(int falseSidSum) {
        this.falseSidSum = falseSidSum;
    }

    public int getTrueSidSum() {
        return trueSidSum;
    }

    public void setTrueSidSum(int trueSidSum) {
        this.trueSidSum = trueSidSum;
    }
}
