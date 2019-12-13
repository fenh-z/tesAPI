package apipack.simpletest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Calendar;

/**
 * @Author zhangdx
 * @Parameter
 * @CreateDate 2019/12/12 5:21 下午
 * @Describe
 */

public class Thread_readFile extends Thread {
    public void run() {
        try {
            Calendar calstart = Calendar.getInstance();
            sleep(5000);
            File file = new File("/Users/dxz/Public/ProgramCodes/file/pwd.cfg");
            //给该文件加锁
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileChannel fileChannel = randomAccessFile.getChannel();
            FileLock fileLock = null;
            while (true) {
                try {
                    fileLock = fileChannel.tryLock();
                    break;
                } catch (Exception e) {
                    System.out.println("有其他线程正在操作该文件，当前线程" + Thread.currentThread().getName() + "休眠1000毫秒");
                    sleep(1000);
                }
            }
            byte[] buf = new byte[1024];
            StringBuffer sb = new StringBuffer();
            while ((randomAccessFile.read(buf)) != -1) {
                sb.append(new String(buf, "utf-8"));
                buf = new byte[1024];
            }

            System.out.println(sb.toString());

            fileLock.release();
            fileChannel.close();
            randomAccessFile.close();
            randomAccessFile = null;

            Calendar calend = Calendar.getInstance();
            System.out.println("当前线程:" + Thread.currentThread().getName() + ",读文件共花了" + (calend.getTimeInMillis() - calstart.getTimeInMillis()) + "秒");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Thread_readFile readFileThread = new Thread_readFile();
        readFileThread.setName("readFileThread");
        Thread_readFile writeFileThread2 = new Thread_readFile();
        writeFileThread2.setName("readFileThread2");

        readFileThread.start();
        writeFileThread2.start();
    }

}
