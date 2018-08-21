package apipack.enums;

/**
 * apipack.enums
 *
 * @Author zhangdongxiao
 * @Date 2018/5/10 下午5:56.
 */
public class EnumMain {

    public static void main(String[] args) {

        String str = "SUMMER";

        System.out.println("@@@@@@@=" + SeasonEnum.AUTUMM.name());

        if (str.equals(SeasonEnum.SUMMER.name())) {
            System.out.println(" SUMMER is " + SeasonEnum.SUMMER);
        }

    }

}
