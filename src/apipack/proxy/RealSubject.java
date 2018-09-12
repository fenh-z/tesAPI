package apipack.proxy;

/**
 * apipack.proxy
 *
 * @author zhangdongxiao
 * @create 2018-09-12 下午5:39
 * @desc RealSubject
 */
public class RealSubject implements ISubject {
    @Override
    public void rent() {
        System.out.println("I want to rent my house");
    }

    @Override
    public void hello(String str) {
        System.out.println("hello: " + str);
    }
}
