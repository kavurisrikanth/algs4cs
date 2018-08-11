public class WeightedQuickUnionUF {
    private int[] connections, sizes;

    public WeightedQuickUnionUF(int n) {
        connections = new int[n];
        sizes = new int[n];
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
        if(x_root == y_root)
            return;
        if(sizes[x_root] < sizes[y_root]) {
            connections[x_root] = y_root;
            sizes[y_root] += sizes[x_root];
        } else {
            connections[y_root] = x_root;
            sizes[x_root] += sizes[y_root];
        }
    }

    public boolean connected(int x, int y) {
        int x_root = root(x),
            y_root = root(y);

        return x_root == y_root;
    }
}
