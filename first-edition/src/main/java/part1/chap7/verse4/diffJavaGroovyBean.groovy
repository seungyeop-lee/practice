package part1.chap7.verse4

// 자바 빈
public class MyBeanJava implements Serializable {
    private String myprop;

    public String getMyprop() {
        return myprop;
    }
    void setMyprop(String myprop) {
        this.myprop = myprop
    }
}

// 그루비 빈
class MyBeanGroovy implements Serializable {
    String myprop
}