package apipack.simpeltest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * apipack
 *
 * @Author zhangdongxiao
 * @Date 2018/5/17 下午2:16.
 */
public class SystemTest {

    public static void main(String[] args) throws IOException {

        Map<String, String> env = System.getenv();

        System.out.println(env);

        for (String name : env.keySet()) {

            System.out.println("@@@@  name = " + name + ";\n@@@@  value = " + env.get(name));

        }

        Properties props = System.getProperties();

        props.store(new FileOutputStream("prop.txt"), "SYSTEM.PROPS");


        System.out.println(System.getProperty("os.name"));

    }

}
