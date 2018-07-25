package apipack.lambda;

/**
 * apipack.lambda
 *
 * @Author zhangdongxiao
 * @Date 2018/5/10 下午3:49.
 */
@FunctionalInterface
public interface Convert {

    Object convert(String arg);

}
