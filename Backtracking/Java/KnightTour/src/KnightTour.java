import java.util.ArrayList;

public class KnightTour {
    int[][] chessBoard;
    int size;
    boolean isClosed;

    // Constructor
    public KnightTour(int size, boolean isClosed) {
        this.size = size;
        this.initChessBoard();
        this.isClosed = isClosed;
    }

    // Function to start the Knight tour
    public boolean startKnightTour(int row, int col) {

        // Setting the starting position as 0
        chessBoard[row][col] = 0;

        // Start the knight tour with count as 1
        if (find_knight_tour(row, col, 1)) {

            // Print the board if able to find the path
            printBoard();
            return true;
        }

        System.out.println("No Possible Solution");
        return false;
    }

    // Recursive function to find the knight tour
    private boolean find_knight_tour(int row, int col, int count) {

        // Base Case - All the positions are covered
        if (count == size * size) {

            // Return true at this point if open knight tour
            if (!isClosed) {
                return true;
            }

            // If closed knight tour
            // Find all the possible moves from the last position
            ArrayList<int[]> possibleMoves = findPossibleMoves(row, col);

            // Looping over all the possible moves
            for (int[] possibleMove : possibleMoves) {

                // Return true if any possible move lead to starting point
                if (chessBoard[possibleMove[0]][possibleMove[1]] == 0) {
                    return true;
                }
            }

            // Return false if starting point is unreachable from the last position
            return false;
        }

        // Find all the possible moves from the given position
        ArrayList<int[]> possibleMoves = findPossibleMoves(row, col);

        // Looping over all the possible moves
        for (int[] possibleMove : possibleMoves) {

            // If possible move is not already covered
            if (chessBoard[possibleMove[0]][possibleMove[1]] == -1) {

                // Update the new position with count
                chessBoard[possibleMove[0]][possibleMove[1]] = count;

                // Find the possible move from the new position with incremented count
                // Return true if able to find the move else backtrack
                if (find_knight_tour(possibleMove[0], possibleMove[1], count + 1)) {
                    return true;
                }

                // Backtracking - Setting back the current position to -1
                chessBoard[possibleMove[0]][possibleMove[1]] = -1;
            }
        }

        // Return false if not able to find the move
        return false;
    }

    // Function to find all possible moves from a given position
    public ArrayList<int[]> findPossibleMoves(int row, int col) {
        ArrayList<int[]> possibleMoves = new ArrayList<>(8);
        if (row + 1 < size && col + 2 < size) {
            possibleMoves.add(new int[] { row + 1, col + 2 });
        }
        if (row + 1 < size && col - 2 >= 0) {
            possibleMoves.add(new int[] { row + 1, col - 2 });
        }
        if (row - 1 >= 0 && col + 2 < size) {
            possibleMoves.add(new int[] { row - 1, col + 2 });
        }
        if (row - 1 >= 0 && col - 2 >= 0) {
            possibleMoves.add(new int[] { row - 1, col - 2 });
        }
        if (row + 2 < size && col + 1 < size) {
            possibleMoves.add(new int[] { row + 2, col + 1 });
        }
        if (row + 2 < size && col - 1 >= 0) {
            possibleMoves.add(new int[] { row + 2, col - 1 });
        }
        if (row - 2 >= 0 && col + 1 < size) {
            possibleMoves.add(new int[] { row - 2, col + 1 });
        }
        if (row - 2 >= 0 && col - 1 >= 0) {
            possibleMoves.add(new int[] { row - 2, col - 1 });
        }
        return possibleMoves;
    }

    // Function to initialize the chess board with -1
    private void initChessBoard() {
        chessBoard = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                chessBoard[i][j] = -1;
            }
        }
    }

    // Function to print the board
    public void printBoard() {
        for (int[] row : this.chessBoard) {
            for (int j = 0; j < this.chessBoard.length; j++) {
                System.out.print(row[j] + "\t");
            }
            System.out.print("\n");
        }
    }
}
