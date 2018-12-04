package apipack.simpeltest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * apipack
 *
 * @Author zhangdongxiao
 * @Date 2018/1/29 上午10:36.
 */
public class TestLambda {

    public static void main(String[] args) {

        List<String> argsList = new ArrayList<>();

        argsList.add("a21");
        argsList.add("a34");
        argsList.add("a61");
        argsList.add("a73");
        argsList.add("a47");
        argsList.add("a61");
        argsList.add("a55");
        argsList.add("a34");
        argsList.add("a10");
        argsList.add("a21");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (String n : argsList) {
                    System.out.println(n);
                }

            }
        });


        Thread t2 = new Thread(() -> argsList.forEach(n -> System.out.println(n)));

        System.out.println("t1.start()");
        t1.start();

        System.out.println();

        System.out.println("t1.start()");
        t2.start();

        System.out.println();

        arrayFilter(argsList, (str) -> str.equals("a21"));

        System.out.println();

        arrayFilterTradition(argsList, (str) -> str.equals("a47"));

        System.out.println();
        arrayFilter(argsList, (str) -> true);

        System.out.println();

        List<String> language = Arrays.asList("Java", "Swift", "Objective-c", "C++");

        Predicate<String> startWithJ = (n) -> n.startsWith("J");
        Predicate<String> length4 = (n) -> n.length() >= 4;

        arrayFilterAndOr(language, startWithJ, length4);


        int[] a = new int[10];

        List<Integer> newAttr = new ArrayList<>();

        Arrays.stream(a).sorted().filter((i) -> i > 0).forEach((i) -> newAttr.add(i));




    }

    public static void arrayFilterAndOr(List<String> arrs, Predicate<String> condition1, Predicate<String> condition2) {
        System.out.println("arrayFilterAndOr");

        arrs.stream().filter(condition1.or(condition2)).forEach((n) -> System.out.println(n));

    }

    public static void arrayFilter(List<String> arrs, Predicate condition) {
        System.out.println("arrayFilter");
        arrs.stream().filter((arr) -> condition.test(arr)).forEach((name) -> System.out.println(name));
    }

    public static void arrayFilterTradition(List<String> arrs, Predicate condition) {

        System.out.println("arrayFilterTradition");
        for (String name : arrs) {
            if (condition.test(name)) {
                System.out.println(name);
            }
        }

    }

}
