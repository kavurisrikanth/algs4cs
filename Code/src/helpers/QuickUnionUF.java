package helpers;

public class QuickUnionUF {
    private int[] connections;

    public QuickUnionUF(int n) {
        connections = new int[n];
        for (int i = 0; i < n; i++)
            connections[i] = i;
    }

    private int root(int x) {
        if(x < 0 || x >= connections.length)
            return -1;

        while(x != connections[x]) {
            x = connections[x];
        }

        return x;
    }

    public void union(int x, int y) {
        int x_root = root(x),
            y_root = root(y);

        connections[x_root] = y_root;
    }

    public boolean connected(int x, int y) {
        int x_root = root(x),
            y_root = root(y);

        return x_root == y_root;
    }
}
