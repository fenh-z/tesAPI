package apipack.containt;

import java.util.ArrayList;
import java.util.List;

/**
 * apipack.containt
 *
 * @Author zhangdongxiao
 * @Date 2018/5/17 下午6:01.
 */
public class CollectionTest {

    public static void main(String[] args) {

        A a = new A("A1");

        System.out.println("1111 a = " + a.toString());

        List<A> aList = new ArrayList();

        aList.add(a);

        System.out.println("2222 aList = " + aList);

        for (A atmp : aList) {

            atmp.setName("A2");

        }

        System.out.println("3333 aList = " + aList);

        System.out.println("4444 a = " + a.toString());


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

    @Override
    public String toString() {
        return "A{" +
                "name='" + name + '\'' +
                '}';
    }
}