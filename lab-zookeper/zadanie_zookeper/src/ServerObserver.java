import java.util.Set;

public interface ServerObserver {
    public void onDataChanged(String host, Set<String> nodes, int childrenCount);
}
