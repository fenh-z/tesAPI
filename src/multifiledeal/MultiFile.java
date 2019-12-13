package multifiledeal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhangdx
 * @Parameter
 * @CreateDate 2019/12/12 5:54 下午
 * @Describe
 */
public class MultiFile {

    static List<File> files = new ArrayList<>();
    static String dealDir = "/Users/dxz/Public/ProgramCodes/file/multi/";

    public static void main(String[] args) {

        File dir = new File(dealDir);

        File[] dirFile = dir.listFiles();

        for (File file : dirFile) {

            System.out.println("1111");

            RandomAccessFile rf = null;
            FileChannel fc = null;
            FileLock lock = null;
            try {
                rf = new RandomAccessFile(file, "rw");
                fc = rf.getChannel();

                lock = fc.tryLock();

                if (lock != null) {

                    System.out.println("22222");
                    files.add(file);
                    System.out.println("33333");
                    Thread.sleep(5000);

                    lock.release();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (rf != null) {
                    try {
                        rf.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fc != null) {
                    try {
                        fc.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (lock != null) {
                    try {
                        lock.release();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        files.forEach(file -> System.out.println("!!!!!" + file.getName()));

    }

}
