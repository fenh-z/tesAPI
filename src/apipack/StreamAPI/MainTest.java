package apipack.StreamAPI;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * apipack.StreamAPI
 *
 * @Author zhangdongxiao
 * @Date 2018/5/18 下午3:42.
 */
public class MainTest {

    public static void main(String[] args) {

        IntStream is = IntStream.builder().add(1).add(4).add(5).add(6).build();

        System.out.println(Arrays.toString(is.toArray()));


        A a1 = new A("App");
        A a2 = new A("Asss");

        Stream<Object> aStream = Stream.builder().build();

        Map<String, Object> m1 = new HashMap<>();
        m1.put("A", "a");
        Map<String, Object> m2 = new HashMap<>();
        m1.put("B", "b");
        Map<String, Object> m3 = new HashMap<>();
        m1.put("C", "c");
        Map<String, Object> m4 = new HashMap<>();
        m1.put("D", "d");

        List<Map<String, Object>> list = new ArrayList<>();

        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);

        System.out.println("@@@  list count = "+list.stream().count());

        Set<A> aSet = new TreeSet<>();


    }

}

class A {
    private String name;

    public A(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
