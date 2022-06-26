public class Main {
    public static void main(String[] args) {
        String[][] maze = new String[][]{
                {".",".",".",".",".","."},
                {"=","=","=",".","=","="},
                {".",".",".",".","=","."},
                {".","=","=","=","=","."},
                {".","=","=","=","=","."},
                {".",".",".",".",".","."},
        };
        MazeSolver mazeSolver = new MazeSolver(maze, new int[]{0, 0}, new int[]{5, 5});
        mazeSolver.solveMaze();
        mazeSolver.printMaze();
    }
}
