import javax.swing.*;

import static java.lang.Thread.sleep;

public class Main {

    static void startNodeMonitors(JTreeApp.TreePanel tpanel){
        String nodePath = "/z"; // Replace with the actual node path
//        ZooKeeperNodeMonitor nodeMonitor = new ZooKeeperNodeMonitor(nodePath, "localhost:2181");

        ZooKeeperNodeMonitor[] nodeMonitors = {
            new ZooKeeperNodeMonitor(nodePath, "localhost:2181"),
            new ZooKeeperNodeMonitor(nodePath, "localhost:2182"),
            new ZooKeeperNodeMonitor(nodePath, "localhost:2183")
        };

        for (var nm : nodeMonitors) {
            nm.setServerObserver(tpanel);
            nm.connect();
        }

        try {
            sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally{
            for (var nm : nodeMonitors) {
                if (nm.zooKeeper != null) {
                    try {
                        nm.zooKeeper.close();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Drzewo");
        JTreeApp.TreePanel tpanel=new JTreeApp.TreePanel();
        frame.setContentPane(tpanel);

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            sleep(500);
                            startNodeMonitors(tpanel);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
        ).start();


        frame.setSize(500, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
//        new JTree2.UpdateThread(tpanel).start();

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
               System.exit(0);
            }
        });

        frame.setVisible(true);


    }
}
