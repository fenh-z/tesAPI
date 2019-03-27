package apipack.tmplt;

import java.util.Arrays;

/**
 * apipack.tmplt
 *
 * @author zhangdongxiao
 * @create 2019-03-20 14:17
 * @desc [M053430<EXP_RULE_ID = 1 0 0 4 7>| M053431< EXP_RULE_ID = 10047>]
 */
public class TmpltParam {

    public static void main(String[] args) {
        String str = "[M053430<ROLE_ID=10047,EXP_RULE_ID=1001>|M053431<ROLE_ID=10047>]";
        System.out.println(str.indexOf("["));
        System.out.println(str.indexOf("]"));

        String substr = str.substring(str.indexOf("[") + 1, str.indexOf("]"));

        System.out.println(substr);

        String[] params = substr.split("\\|");

        Arrays.stream(params).forEach(param -> {

            System.out.println();
            System.out.println("@@@@@==" + param);

            String subPrc = param.substring(0, param.indexOf("<"));

            String subParams = param.substring(param.indexOf("<") + 1, param.indexOf(">"));

            System.out.println("2222222==" + subPrc);
            System.out.println("3333333==" + subParams);
        });

    }

}
