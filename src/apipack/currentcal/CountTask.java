package apipack.currentcal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * apipack.currentcal
 *
 * @Author zhangdongxiao
 * @Date 2018/6/11 下午5:10.
 */
public class CountTask extends RecursiveTask<Integer> {

    private static final int THREADHOLD = 2;
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        boolean compute = (end - start) <= THREADHOLD;
        int res = 0;
        if (compute){
            for (int i = start; i <= end; i++){
                res += i;
            }
        }else {
            //如果长度大于阈值，则分割为小任务
            int mid = (start + end) / 2;
            CountTask task1 = new CountTask(start,mid);
            CountTask task2 = new CountTask(mid + 1, end);
            //计算小任务的值
            task1.fork();
            task2.fork();
            //得到两个小任务的值
            int task1Res = task1.join();
            int task2Res = task2.join();
            res = task1Res + task2Res;
        }
        return res;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        CountTask task = new CountTask(1,5);
        ForkJoinTask<Integer> submit = pool.submit(task);
        System.out.println("Final result:" + submit.get());
    }
}
