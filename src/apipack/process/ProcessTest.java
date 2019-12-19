package apipack.process;

import java.io.IOException;
import java.util.*;

/**
 * @Author zhangdx
 * @Parameter
 * @CreateDate 2019/12/19 10:14 上午
 * @Describe
 */
public class ProcessTest {

    public static void main(String[] args) throws IOException {

        System.out.println("1111111");

        Map<String, String> environment = new HashMap<>();

        String cmds = "/Users/dxz/Public/ProgramCodes/file/shell/s.sh";

        String[] cmdtmp = cmds.split(" ");

        List<String> buff = new ArrayList<>();

//        Arrays.stream(cmdtmp).forEach(cmd -> buff.add(cmd));

        buff.add(cmds);

        ProcessBuilder builder = new ProcessBuilder(buff);
        builder.redirectErrorStream(true);
        Map<String, String> processEvn = builder.environment();
        for (Map.Entry<String, String> entry : environment.entrySet()) {
            processEvn.put(entry.getKey(), entry.getValue());
        }

        builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        builder.start();

        System.out.println("2222222");

    }

}
