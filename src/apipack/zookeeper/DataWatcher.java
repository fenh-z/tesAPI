package apipack.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * apipack.zookeeper
 *
 * @author zhangdongxiao
 * @create 2018-11-29 4:25 PM
 * @desc zk数据监控
 */
public class DataWatcher implements Watcher {


    public DataWatcher() {
    }

    @Override
    public void process(WatchedEvent event) {
        if(event.getType() == Event.EventType.NodeChildrenChanged){

        }
    }
}
