package apipack.currentcal;

import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

/**
 * apipack.currentcal
 *
 * @Author zhangdongxiao
 * @Date 2018/7/5 下午5:59.
 */
public class LockTest {

    public static void main(String[] args) {

        Account account = new Account("1222", 0);

//        GetActThread getActThread1 = new GetActThread(account, 800);
//        GetActThread getActThread2 = new GetActThread(account, 800);
//
//        Thread t1 = new Thread(getActThread1);
//        Thread t2 = new Thread(getActThread2);
//
//        t1.start();
//        t2.start();
        new DrawThread(account, 800).start();
        new DepositThread(account, 800).start();
        new DepositThread(account, 800).start();
        new DepositThread(account, 800).start();

    }

}

class DrawThread extends Thread {
    private Account account;
    private double drowBalance;

    public DrawThread(Account account, double drowBalance) {
        this.account = account;
        this.drowBalance = drowBalance;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            account.drow(drowBalance);
        }
    }
}

class DepositThread extends Thread {
    private Account account;
    private double depositBalance;

    public DepositThread(Account account, double depositBalance) {
        this.account = account;
        this.depositBalance = depositBalance;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            account.deposit(depositBalance);
        }
    }
}

class GetActThread implements Runnable {

    private Account account;
    private double drowBalance;

    public GetActThread(Account account, double drowBalance) {
        this.account = account;
        this.drowBalance = drowBalance;
    }

    @Override
    public void run() {
        account.drow(drowBalance);
    }
}

class Account {

    private final ReentrantLock lock = new ReentrantLock();
    private String actNo;
    private double balance;
    private boolean isEmpty = false;

    public Account(String actNo, double balance) {
        this.actNo = actNo;
        this.balance = balance;
    }

    public synchronized void drow(double drowBalance) {

//        lock.lock();
//        try {

//        if (balance >= drowBalance) {
//
//            System.out.println("get " + drowBalance + " success !!");
//
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            balance -= drowBalance;
//
//            System.out.println("balance is " + balance);
//
//        } else {
//            System.out.println(Thread.currentThread().getName() + " no much more balance");
//        }
//    }
//        finally{
//            lock.unlock();
//        }


        try {
            if (isEmpty) {
                wait();
            } else {
                System.out.println(Thread.currentThread().getName() + "get money " + drowBalance);
                balance -= drowBalance;

                System.out.println("account left " + balance);

                isEmpty = true;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void deposit(double depositAmount) {

        try {
            if (!isEmpty) {
                wait();
            } else {
                System.out.println(Thread.currentThread().getName() + "put money " + depositAmount);
                balance += depositAmount;
                System.out.println("account left " + balance);

                isEmpty = false;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(account.balance, balance) == 0 &&
                Objects.equals(actNo, account.actNo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(actNo, balance);
    }
}
