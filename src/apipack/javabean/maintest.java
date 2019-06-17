package apipack.javabean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * apipack.javabean
 *
 * @Author zhangdongxiao
 * @Date 2018/6/28 下午4:54.
 */
public class maintest {

    public static void main(String[] args) {

//        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");

        SimpleDateFormat sdf0 = new SimpleDateFormat("mmss");
        Date date = new Date();

        String dataStmp = sdf0.format(date);

        System.out.println("time it is " + dataStmp);
        System.out.println("time stmp it is " + dataStmp.substring(1));

        if (dataStmp.substring(1).equals("1")) {
            System.out.println(111111);
        } else {
            System.out.println(222222);
        }

        int i = Integer.valueOf(dataStmp.substring(1));

        System.out.println("mod = " + i % 500 );

    }

}
