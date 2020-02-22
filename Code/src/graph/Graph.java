/**
 * Undirected graph
 */

package graph;

public class Graph extends BaseGraph {

    private boolean[] reachable;

    public Graph(int n) {
        super(n);
        reachable = new boolean[n];
    }

    public void insert(int node) {

    }

    public void connect(int one, int other) {
        assert isCorrectIndex(one) && isCorrectIndex(other);
        adj[one].add(other);
        adj[other].add(one);
        e++;
    }

    public boolean areConnected(int one, int other) {
        assert isCorrectIndex(one) && isCorrectIndex(other);
        // TODO: Implement this
        dfs(one);
        return reachable[other];
    }

    public int v() {
        return v;
    }

    public int e() {
        return e;
    }

    public void resetDfs() {
        reachable = new boolean[v];
    }

    private void dfs() {
        reachable = new boolean[v];
        dfs(0);
    }

    private void dfs(int start) {
        reachable[start] = true;
        for (int next : adj[start]) {
            if (!reachable[next]) {
                dfs(next);
            }
        }
    }
}
