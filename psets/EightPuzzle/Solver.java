import edu.princeton.cs.algs4.MinPQ;

import java.util.ArrayList;

public class Solver {
    private class SearchNode implements Comparable<SearchNode> {
        Board current, previous;
        int moves;

        SearchNode(Board previous, Board current, int moves) {
            this.current = current;
            this.previous = previous;
            this.moves = moves;
        }

        @Override
        public int compareTo(SearchNode o) {
            return Integer.compare(moves + current.manhattan(), o.moves + o.current.manhattan());
        }
    }

    private ArrayList<Board> solution;
    private boolean solvable;
    private int minMoves;

    public Solver(Board initial){
        // find a solution to the initial board (using the A* algorithm)
        solvable = false;
        solution = new ArrayList<>();
        minMoves = 0;

        if (initial.isGoal()) {
            solvable = true;
            solution.add(initial);
            return;
        }

        MinPQ<SearchNode> q = new MinPQ<>();
        SearchNode node = new SearchNode(null, initial, 0);
        q.insert(node);

        while (!q.isEmpty()) {
            // Get the current minimum Board.
            node = q.delMin();
            Board current = node.current,
                  previous = node.previous;
            int moves = node.moves;

            // Add the current Board to the solution.
            solution.add(current);
//            System.out.println("Board added to solution:");
//            System.out.println(current);
//            System.out.println();

            // If the current board is the goal board, then we're done.
            if (current.isGoal()) {
                solvable = true;
                minMoves = moves;
                return;
            }

            // Go through the neighboring boards and insert into the MinPQ if the neighbor doesn't
            // equal the previous board.
            Iterable<Board> possibleBoards = current.neighbors();
            for (Board b: possibleBoards) {
                if (!b.equals(previous))
                    q.insert(new SearchNode(current, b, moves + 1));
            }
        }

        minMoves = -1;
        solution = null;
    }

    public boolean isSolvable(){
        // is the initial board solvable?
        // Just return true for now
        return solvable;
    }

    public int moves(){
        // min number of moves to solve initial board; -1 if unsolvable
        return minMoves;
    }

    public Iterable<Board> solution(){
        // sequence of boards in a shortest solution; null if unsolvable
        return solution;
    }

    public static void main(String[] args){
        // solve a slider puzzle (given below)

    }
}
