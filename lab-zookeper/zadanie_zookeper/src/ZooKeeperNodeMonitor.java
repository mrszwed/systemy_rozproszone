import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.*;

public class ZooKeeperNodeMonitor  {
//    private static final String ZOOKEEPER_ADDRESS = "localhost:2181";
    private static final int SESSION_TIMEOUT = 5000;
    private final String hostAdress;
    ServerObserver serverObserver;

    Set<String> nodes=new TreeSet<>();

    public ZooKeeper zooKeeper;
    private String nodePath;

    public ZooKeeperNodeMonitor(String nodePath, String hostAddress) {
        this.nodePath = nodePath;
        this.hostAdress=hostAddress;
    }

    public void setServerObserver(ServerObserver serverObserver) {
        this.serverObserver = serverObserver;
    }

    class NodeWatcher implements Watcher{
        Process process;

        @Override
        public void process(WatchedEvent watchedEvent) {
            try {
                System.out.println(watchedEvent);
                if(watchedEvent.getType()==Event.EventType.NodeCreated){
                    zooKeeper.getChildren(nodePath,childrenWatcher);
                    if(serverObserver!=null){
                        serverObserver.onDataChanged(hostAdress, Collections.singleton(nodePath),1);
                    }
                    //otworz apke
                    process=Runtime.getRuntime().exec("C:\\Program Files\\Notepad++\\notepad++.exe");
                }
                if(watchedEvent.getType()==Event.EventType.NodeDeleted){
                    if(serverObserver!=null){
                        serverObserver.onDataChanged(hostAdress, new TreeSet<>(),0);
                    }
                    //zamknij apke
                    if(process!=null)process.destroy();
                }
                zooKeeper.exists(nodePath,this);

            }

            catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (KeeperException e) {
                e.printStackTrace();
            }
        }
    }
    class ChildrenWatcher implements Watcher{

        @Override
        public void process(WatchedEvent watchedEvent) {
            System.out.println(watchedEvent);
            nodes.clear();

            parseChildren(nodePath);
            if(serverObserver!=null){
                System.out.println("========================");
                int chCnt = 0;
                try {
                    chCnt = zooKeeper.getAllChildrenNumber(nodePath);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                serverObserver.onDataChanged(hostAdress, nodes,chCnt);
            }

        }
    }
    ChildrenWatcher childrenWatcher=new ChildrenWatcher();

    void parseChildren(String root)  {
        List<String> children = null;
        try {
            children = zooKeeper.getChildren(root,childrenWatcher);
            nodes.add(root);
            for(var ch : children){
                String childNode=root+"/"+ch;
                nodes.add(childNode);
                parseChildren(childNode);
            }

        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public void connect(){
        try {
            zooKeeper = new ZooKeeper(hostAdress, SESSION_TIMEOUT, null);

            zooKeeper.exists(nodePath,new NodeWatcher());
            parseChildren(nodePath);
            for(var ch:nodes){
                System.out.println(ch);
            }

            var xx = zooKeeper.getAllChildrenNumber("/z");
            System.out.println("Number:"+xx);

            if(serverObserver!=null){
                System.out.println("========================");
                serverObserver.onDataChanged(hostAdress, nodes,xx);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        String nodePath = "/z"; // Replace with the actual node path
        ZooKeeperNodeMonitor nodeMonitor = new ZooKeeperNodeMonitor(nodePath, "localhost:2181");
        try {
            nodeMonitor.connect();

            // Keep the main thread running
            Thread.sleep(Long.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (nodeMonitor.zooKeeper != null) {
                try {
                    nodeMonitor.zooKeeper.close();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
