package apipack.zookeeper;

import apipack.common.Constant;
import com.sitech.hsf.common.logger.Logger;
import com.sitech.hsf.common.logger.LoggerFactory;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.IZkStateListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Watcher;

/**
 * apipack.zookeeper
 *
 * @author zhangdongxiao
 * @create 2018-12-04 2:58 PM
 * @desc zookeeper处理工具
 */
public class ZKClientUtil {

    private static Logger log = LoggerFactory.getLogger(ZKClientUtil.class);

    private static ZkClient client;

    public ZKClientUtil() {
        this.client = new ZkClient(Constant.ZK_BROKER_URL, 2000);
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println("begin");

        ZKClientUtil zk = new ZKClientUtil();

        String data = Constant.ZK_BROKER_URL + "  " + Constant.ZNODE + " this is test";

        final String[] subscribeStr = {""};

        client.subscribeDataChanges(Constant.ZNODE, new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                System.out.println("@@@@@@ data change");
                System.out.println("@@@@@@ s=" + s);
                System.out.println("@@@@@@ o=" + o);
                subscribeStr[0] = o.toString() + " ; " + "subscribeDataChanges";
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {

            }
        });

        client.subscribeStateChanges(new IZkStateListener() {
            @Override
            public void handleStateChanged(Watcher.Event.KeeperState keeperState) throws Exception {
                System.out.println("handleStateChanged");
            }

            @Override
            public void handleNewSession() throws Exception {
                System.out.println("handleNewSession");
            }

            @Override
            public void handleSessionEstablishmentError(Throwable throwable) throws Exception {
                System.out.println("handleSessionEstablishmentError");
            }
        });

        while (true) {

            if (!client.exists(Constant.ZNODE)) {
                System.out.println(Constant.ZNODE + " is not exists");
                client.create(Constant.ZNODE, data, CreateMode.PERSISTENT);
                Thread.sleep(1000);
            } else {
                System.out.println(Constant.ZNODE + " is exists");
                client.writeData(Constant.ZNODE, data);
                Thread.sleep(1000);
            }

            String clientResult = client.readData(Constant.ZNODE);
            Thread.sleep(1000);
            System.out.println();
            System.out.println("!!!!!data result = " + clientResult);

            System.out.println();
            System.out.println(Constant.ZNODE + " begin overwrite ");
            client.writeData(Constant.ZNODE, data);


            System.out.println();

            System.out.println("@@@@@@@@@@  subscribeStr[0] = " + subscribeStr[0]);

//            client.close();

            Thread.sleep(1000);
        }


    }


}
