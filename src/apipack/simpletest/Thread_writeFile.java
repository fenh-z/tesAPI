package apipack.simpletest;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Calendar;

public class Thread_writeFile extends Thread {
    public void run() {
        Calendar calstart = Calendar.getInstance();
        File file = new File("/Users/dxz/Public/ProgramCodes/file/test.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            //对该文件加锁
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileChannel fileChannel = randomAccessFile.getChannel();
            FileLock fileLock = null;
            while (true) {
                try {
                    sleep(10000);
                    fileLock = fileChannel.tryLock();
                    System.out.println("111111");

                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("有其他线程正在操作该文件，当前线程" + Thread.currentThread().getName() + "休眠1000毫秒");
                    sleep(1000);
                }

            }
            System.out.println("2222222");
            for (int i = 1; i <= 1000; i++) {
                sleep(10);
                StringBuffer sb = new StringBuffer();
                sb.append(Thread.currentThread().getName() + "tttttt  这是第" + i + "行对应的数据");
                sb.append("\n");
                randomAccessFile.write(sb.toString().getBytes("utf-8"));
            }
            fileLock.release();
            fileChannel.close();
            randomAccessFile.close();
            randomAccessFile = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        Calendar calend = Calendar.getInstance();
        System.out.println("线程:" + Thread.currentThread().getName() + ",写文件共花了" + (calend.getTimeInMillis() - calstart.getTimeInMillis()) + "秒");
    }


    public static void main(String[] args) {
        Thread_writeFile writeFileThread = new Thread_writeFile();
        writeFileThread.setName("writeFileThread n1");
        Thread_writeFile writeFileThread2 = new Thread_writeFile();
        writeFileThread2.setName("writeFileThread n2");
        writeFileThread.start();
//        writeFileThread2.start();
    }
}