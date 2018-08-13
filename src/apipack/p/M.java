package apipack.p;

/**
 * apipack.p
 *
 * @Author zhangdongxiao
 * @Date 2018/8/13 下午4:57.
 */
public class M {

    public static void main(String[] args) {

        Data a = new Data("4");

        System.out.println(a.toString());
        new M().chgArg(a);
        System.out.println(a.toString());

    }

    public void chgArg(Data data){
        data.a = "b";
    }

}


class Data{

    String a;

    public Data(String a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Data{" +
                "a='" + a + '\'' +
                '}';
    }
}
