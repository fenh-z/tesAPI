package apipack.InterfaceTest;

/**
 * apipack.InterfaceTest
 *
 * @Author zhangdongxiao
 * @Date 2018/5/8 上午10:26.
 */
public interface B {

    default void hello(){
        System.out.println("Hello B");
    }

}
