package apipack.enums;

/**
 * apipack.enums
 *
 * @Author zhangdongxiao
 * @Date 2018/5/15 下午4:11.
 */
public enum Operation {

    PLUS{
        @Override
        public double eval(double x, double y) {
            return x+y;
        }
    },
    MINUS{
        @Override
        public double eval(double x, double y) {
            return x-y;
        }
    };

    public abstract double eval(double x, double y);

    public static void main(String[] args) {
        System.out.println(Operation.PLUS.eval(3, 8));
        System.out.println(Operation.MINUS.eval(3,8));
    }

}
