package apipack.simpletest;

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

//        Map<String, Object> map = new HashMap<>();
//
//        List<String> list = new ArrayList<>();
//        String a = "1";
//        String b = "2";
//        String c = "3";
//
//        for (String str : list) {
//            if (str.equals("3") || str.equals("2")) {
//                str += str;
//                str += "_";
//            }
//        }

        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>() {
            {
                put(1, 1);
                put(2, 2);
            }
        };

        System.out.println("map1 =" + map1.toString());

        Map<Integer, Integer> map2 = new HashMap<>(map1);

        map1.put(3,3);

        System.out.println("map1 =" + map1.toString());

        System.out.println("map2 =" + map2.toString());

    }

}

class MainClass {

    public MainClass() {
        System.out.println("this is mainclass");
    }
}

class SubClass extends MainClass {

    public SubClass() {
        System.out.println("this is sbumainclass");
    }
}
