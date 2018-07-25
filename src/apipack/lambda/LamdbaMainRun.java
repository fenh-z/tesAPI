package apipack.lambda;

/**
 * apipack.lambda
 *
 * @Author zhangdongxiao
 * @Date 2018/5/10 下午3:50.
 */
public class LamdbaMainRun {

    public static void main(String[] args) {

        Convert c_Str2Int = fromStr -> Integer.valueOf(fromStr);

        int i_ConverArg = (int) c_Str2Int.convert("10");

        System.out.println("@@@@@  i_ConverArg = " + i_ConverArg);

        Convert c_Str2Double = fromStr -> Double.valueOf(fromStr);

        double d_ConvertArg = (double) c_Str2Double.convert("30");

        System.out.println("@@@@@ d_ConvertArg = " + d_ConvertArg);

        SubStr subStr = (arg0, arg1) -> {

            if (arg0.contains(arg1)) {

                int idx = arg0.indexOf(arg1);
                String retStr = arg0.substring(idx);

                return retStr;
            } else {
                return null;
            }

        };

        String newStr = subStr.sub("abcdefg", "efg");

        System.out.println("newStr = " + newStr);

    }

}
