package apipack.simpeltest;

import java.util.Arrays;

/**
 * apipack
 *
 * @Author zhangdongxiao
 * @Date 2018/3/9 下午6:30.
 */
public class Stringtest {

    public static void main(String[] args) {
        String str = "123weqweqsd||||";

        String reg = "\\|";

        String[] strArr = str.split(reg);

        System.out.println(Arrays.toString(strArr));

    }

}
