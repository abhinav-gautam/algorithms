import java.util.ArrayList;

public class MazeSolver {
    String[][] maze;
    int size;
    ArrayList<String> pathArray;
    int[] destination;
    int[] source;

    // Constructor
    public MazeSolver(String[][] maze, int[] source, int[] destination) {
        this.maze = maze;
        this.source = source;
        this.destination = destination;
        this.size = maze.length;
        this.pathArray = new ArrayList<>(size);
    }

    // Function to start solving the maze
    public void solveMaze() {

        // If solution of maze is found
        if (findPath(source[0], source[1])) {

            // Labelling the starting position as S and destination as D
            maze[source[0]][source[1]] = "S";
            maze[destination[0]][destination[1]] = "D";

            System.out.println(pathArray);

            return;
        }
        System.out.println("No possible solution from this point.");
    }

    // Recursive function to find path in the maze
    private boolean findPath(int row, int col) {

        // Base Case - if reached the destination
        if (row == destination[0] && col == destination[1]) {
            return true;
        }

        // Getting the possible moves for a given position
        ArrayList<int[]> possibleMoves = findPossibleMoves(row, col);

        // Looping over all the possible moves
        for (int[] possibleMove : possibleMoves) {

            // Add the current possible move in the solution array
            addToPathArray(possibleMove[2]);

            // Update the maze as per the move
            paintMaze(possibleMove);

            // Find the path from new position
            // If path leads to destination then return true else backtrack
            if (findPath(possibleMove[0], possibleMove[1])) {
                return true;
            }

            // Backtracking - Remove the current possible move from the solution array
            // Remove the possible move from the maze too
            pathArray.remove(pathArray.size() - 1);
            maze[possibleMove[0]][possibleMove[1]] = ".";
        }

        // Return true if not able to find the path
        return false;
    }

    // Function to update the maze with the move
    private void paintMaze(int[] possibleMove) {

        if (possibleMove[2] == 3 || possibleMove[2] == 1) {

            // If move is either up or down use pipe `|`
            maze[possibleMove[0]][possibleMove[1]] = "|";
        } else {

            // If move is either left or right use hyphen `-`
            maze[possibleMove[0]][possibleMove[1]] = "-";
        }
    }

    // Function to map the move number to direction and add in the solution array
    private void addToPathArray(int num) {
        String direction = "";
        switch (num) {
            case 0 -> direction = "Right";
            case 1 -> direction = "Down";
            case 2 -> direction = "Left";
            case 3 -> direction = "Up";
        }
        pathArray.add(direction);
    }

    // Function to find the possible move from a given position
    private ArrayList<int[]> findPossibleMoves(int row, int col) {

        // Initialize an array to store the possible moves
        ArrayList<int[]> possibleMoves = new ArrayList<>(4);

        // Possible directions can be anyone of Roght, Left, Up and Down
        int[] possibleRows = new int[] { 0, 1, 0, -1 };
        int[] possibleCols = new int[] { 1, 0, -1, 0 };

        // Looping over the possible directions to check if move is possible
        for (int i = 0; i < 4; i++) {

            // Finding the position after the move
            int nextRow = row + possibleRows[i];
            int nextCol = col + possibleCols[i];

            // If next position is valid then add to the possible moves array
            // Next position is invalid if obstacle is present or out of the maze or already
            // covered
            if (nextRow < size && nextRow >= 0 && nextCol < size && nextCol >= 0 && !maze[nextRow][nextCol].equals("=")
                    && !maze[nextRow][nextCol].equals("|") && !maze[nextRow][nextCol].equals("-")) {
                possibleMoves.add(new int[] { nextRow, nextCol, i });
            }
        }
        return possibleMoves;
    }

    // Function to print the maze
    public void printMaze() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }
}
