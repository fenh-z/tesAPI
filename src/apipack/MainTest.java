package apipack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * apipack
 *
 * @Author zhangdongxiao
 * @Date 2018/5/17 上午11:46.
 */
public class MainTest {

    public static void main(String[] args) {

        Map<String, Object> map = new HashMap<>();

        map.put("1", 1);

        if("2".equals(map.get("1"))){
            System.out.println(111111);
        }

        System.out.println(222222);

    }

}
