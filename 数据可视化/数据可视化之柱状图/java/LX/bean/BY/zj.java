package LX.bean.BY;

public class zj {
    private String dq;
    private String count;
    private String month;

    public zj() {

    }

    public zj(String dq, String count, String month) {
        this.dq = dq;
        this.count = count;
        this.month = month;
    }

    public String getDq() {
        return dq;
    }

    public void setDq(String dq) {
        this.dq = dq;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "zj{" +
                "dq='" + dq + '\'' +
                ", count='" + count + '\'' +
                ", month='" + month + '\'' +
                '}';
    }
}
