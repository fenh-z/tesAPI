package apipack.InterfaceTest;

/**
 * apipack.InterfaceTest
 *
 * @Author zhangdongxiao
 * @Date 2018/5/8 上午10:27.
 */
public interface C extends B{
    default void hello(){
        System.out.println("Hello C");
    }
}
