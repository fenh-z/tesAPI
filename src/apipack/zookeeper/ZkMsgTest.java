package apipack.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

/**
 * apipack
 *
 * @author zhangdongxiao
 * @create 2018-11-29 10:50 AM
 * @desc
 */
public class ZkMsgTest {

    public static void main(String[] args) {

        String hostPort = "localhost:2182";
        String zpath = "/";

        List<String> zooChildren;
        ZooKeeper zk = null;
        try {
            zk = new ZooKeeper(hostPort, 2000, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (zk != null) {
            try {
                zooChildren = zk.getChildren(zpath, false);
                System.out.println("Znodes of '/': ");
                for (String child : zooChildren) {
                    //print the children
                    System.out.println(child);
                }

                //判断zk节点是否存在
                Stat stat = zk.exists("/testpath", false);

                System.out.println("Znode stat " + stat);

                if (stat == null) {
                    zk.create("/testpath", "this is test msg".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                } else {
                    System.out.println("version=" + stat.getVersion());

                    //向zk写数据
                    zk.setData("/testpath", ("this is test msg" + stat.getVersion()).getBytes(), stat.getVersion());
                }

                System.out.println("version=" + stat.getVersion());

                byte[] data = zk.getData("/testpath", true, stat);

                String dataStr = new String(data);

                System.out.println(dataStr);

            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
