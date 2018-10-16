package cn.szvone.mdkj.dto;

public class MidInfoDto {

    private String mid;
    private String sid;
    private String sidNo;
    private String sidState;

    @Override
    public String toString() {
        return "SidInfoDto{" +
                "mid='" + mid + '\'' +
                ", sid='" + sid + '\'' +
                ", sidNo='" + sidNo + '\'' +
                ", sidState='" + sidState + '\'' +
                '}';
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

    public String getSidNo() {
        return sidNo;
    }

    public void setSidNo(String sidNo) {
        this.sidNo = sidNo;
    }

    public String getSidState() {
        return sidState;
    }

    public void setSidState(String sidState) {
        this.sidState = sidState;
    }
}
