package apipack.simpletest;

import java.util.ArrayList;
import java.util.List;

/**
 * apipack
 *
 * @author zhangdongxiao
 * @create 2018-11-08 11:31 AM
 * @desc
 */
public class ListTest {

    public static void main(String[] args) {

        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(8);
        a.add(9);

        System.out.println(a.size());

        a.remove(6);

        System.out.println(a.size());


    }

}
