public class Main {
    public static void main(String[] args) {
    int[][] sudoku = new int[][]{
            {7,0,0,0,0,0,4,0,0},
            {0,0,8,9,0,5,0,2,0},
            {0,0,0,0,3,0,0,0,0},
            {0,0,3,0,2,0,0,0,0},
            {8,0,0,6,0,3,0,0,7},
            {0,0,0,0,1,0,0,6,0},
            {0,0,5,8,0,6,0,9,0},
            {0,0,0,1,0,0,0,0,0},
            {0,9,0,0,0,0,0,0,2},
    };
    Sudoku sudokuSolver = new Sudoku(sudoku);
    sudokuSolver.startSolving();
    }
}
