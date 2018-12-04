package apipack.simpeltest;

import java.util.HashMap;
import java.util.Map;

/**
 * apipack
 *
 * @Author zhangdongxiao
 * @Date 2018/1/8 上午10:22.
 */
public class TestPutAll {

    public static void main(String[] args) {

        Map<String, Object> m1 = new HashMap<>();

        Map<String, Object> m2 = new HashMap<>();
        m2.put("lll", "ggggg");
        m2.put("kkk", "adadad");

        m1.put("1", m2);
        System.out.println("m1"+m1.toString());

        Map<String,Object> m3 = new HashMap<>();
        m3.put("aaa", "bbbb");

        if(m1.containsKey("1")){
            Map<String, Object> tmp = (Map<String, Object>) m1.get("1");
            tmp.putAll(m3);
        }

        System.out.println("m1"+m1.toString());


    }

}
