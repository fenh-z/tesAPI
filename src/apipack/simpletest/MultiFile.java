package apipack.simpletest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
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

            try {
                RandomAccessFile rf = new RandomAccessFile(file, "rw");
                FileChannel fc = rf.getChannel();
                fc.tryLock();
                files.add(file);

                Thread.sleep(2000);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        files.forEach(file -> System.out.println("!!!!!" + file.getName()));

    }

}
