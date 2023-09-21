import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.*;

public class JTreeApp {

    public static class TreePanel extends JPanel implements ServerObserver{
        Map<String, Set<String>> mapa=new TreeMap<>();
        Map<String, Integer> childrenCounter=new TreeMap<>();
        TreePanel(){
            buildStartTree();
        }

        public void onDataChanged(String host, Set<String> nodes,int childrenCount){
            mapa.put(host, nodes);
            childrenCounter.put(host,childrenCount);
            build();
        }

        void addNode(DefaultMutableTreeNode root, String path){
            root.add(new DefaultMutableTreeNode(path));
        }

        synchronized void build(){
            DefaultMutableTreeNode root = new DefaultMutableTreeNode("zookeper");
            for(var n:mapa.entrySet()){
                String hostKey=n.getKey();
                DefaultMutableTreeNode hostNode = new DefaultMutableTreeNode(hostKey);
                root.add(hostNode);
                for(var s:n.getValue()){
                    if(s.chars().filter(c->c=='/').count()==1){
                        s=String.format(String.format("%s (%d children)",s,childrenCounter.getOrDefault(hostKey,0)));
                    }
                    addNode(hostNode, s);
                }
            }

            if(getComponentCount()>0){
                remove(0);
            }
            JTree tree = new JTree(root);
            for(int i=0;i<tree.getRowCount();i++)tree.expandRow(i);
            // Create a scroll pane and add the JTree to it
            JScrollPane scrollPane = new JScrollPane(tree);
            setLayout(new BorderLayout());
            add(scrollPane,BorderLayout.CENTER);

            doLayout();
        }

        void buildStartTree(){
            DefaultMutableTreeNode root = new DefaultMutableTreeNode("Waiting for connection...");

            JTree tree = new JTree(root);


            JScrollPane scrollPane = new JScrollPane(tree);
            setLayout(new BorderLayout());
            add(scrollPane,BorderLayout.CENTER);
            for(int i=0;i<tree.getRowCount();i++)tree.expandRow(i);
        }

    }

    static Set<String> testDrzewo(){
        String nazwy = """
                /z/ala
                /z/ela
                /z/ela/kkkkkll
                /z/kkk
                /z/kkk/costam
                /z/ula
                /z/ula/krasula
                /z/ulakrasula
               """;
        String[] nazwysplit = nazwy.split("\\s");
        Set<String> zbior=new TreeSet<>();
        for(var s:nazwysplit){
            if(s.isEmpty())continue;
            zbior.add(s);
        }
        return zbior;
    }
    static class UpdateThread extends Thread{
        private final TreePanel tpanel;

        UpdateThread(TreePanel tpanel){
            this.tpanel=tpanel;
        }
        public void run() {
            try {
                sleep(2000);
                tpanel.onDataChanged("localhost:2181", testDrzewo(),11);
                tpanel.onDataChanged("localhost:2182", testDrzewo(),12);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(testDrzewo());
        // write your code here
        JFrame frame = new JFrame("Drzewo");
        TreePanel tpanel=new TreePanel();
        frame.setContentPane(tpanel);
        frame.setSize(500, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
        new UpdateThread(tpanel).start();
        frame.setVisible(true);

    }


}
