package apipack;

import java.util.HashMap;
import java.util.Map;

/**
 * apipack
 *
 * @Author zhangdongxiao
 * @Date 2018/3/26 上午10:36.
 */
public class MapTest {

    public static void main(String[] args) {

        Map<String, String> m1 = new HashMap<>();

        m1.put("1", "sssss");
        m1.put("2", "fffff");
        m1.put("3", "ccccc");

        System.out.println(" m1 add is "+ m1.hashCode());

        m1.clear();

        m1.put("2", "fffff");
        m1.put("3", "ccccc");

        System.out.println(" m1 add is "+ m1.hashCode());


    }

}
