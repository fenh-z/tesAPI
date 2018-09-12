package apipack.tcpclient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * apipack.tcpclient
 *
 * @author zhangdongxiao
 * @create 2018-08-28 下午2:48
 * @desc main
 */
public class MainRun {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();

        System.out.println("localhost = "+inetAddress.getHostAddress());
    }

}
