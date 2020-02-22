package helpers;

public class QuickFindUF {

    private int[] connections;

    public QuickFindUF(int num) {
        connections = new int[num];
        for(int i = 0; i < num; i++)
            connections[i] = i;
    }

    /*****
     * Checks if two components are connected.
     * @param one - First component.
     * @param two - Second component.
     * @return - true or false
     */
    public boolean connected(int one, int two) {
        if (one < 0 || one >= connections.length || two < 0 || two >= connections.length)
            return false;

        return connections[one] == connections[two];
    }

    public void union(int one, int two) {
        if (one < 0 || one >= connections.length || two < 0 || two >= connections.length)
            return;

        if (connected(one, two))
            return;

        int target = connections[one];
        for(int i = 0; i < connections.length; i++)
            if (connections[i] == target)
                connections[i] = connections[two];
    }
}
