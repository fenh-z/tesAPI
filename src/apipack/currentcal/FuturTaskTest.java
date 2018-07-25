package apipack.currentcal;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * apipack.currentcal
 *
 * @Author zhangdongxiao
 * @Date 2018/6/29 下午5:24.
 */
public class FuturTaskTest {

    public static void main(String[] args) {

        FutureTask<Integer> task = new FutureTask<>((Callable<Integer>) () -> {
            int i = 0, a = 1, b = 19, c = 0;
            for (; i < 100; i++) {
                c = a * b;
                System.out.println(Thread.currentThread().getName() + "  i=" + i);
            }

            return c;

        });

        for (int a = 0; a < 100; a++) {
            if (a == 20) {
                new Thread(task, "有返回的 T").start();
            }
        }

        try {
            System.out.println("task.get() = " + task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
