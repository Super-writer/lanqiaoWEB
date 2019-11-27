package LX.bean;

public class yy {
    private int id;
    private String dq;
    private int count;

    public yy() {

    }

    public yy(int id, String dq, int count) {
        this.id = id;
        this.dq = dq;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDq() {
        return dq;
    }

    public void setDq(String dq) {
        this.dq = dq;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "yy{" +
                "id=" + id +
                ", dq='" + dq + '\'' +
                ", count=" + count +
                '}';
    }
}
