public class Sudoku {
    int[][] sudoku;
    private final int size;
    private final int box_size;

    // Constructor
    public Sudoku(int[][] sudoku) {
        this.sudoku = sudoku;
        this.size = sudoku.length;
        this.box_size = (int) Math.sqrt(size);
    }

    // Function to validate if sudoku is valid
    public boolean isSudokuValid() {
        // Looping over all the entries of sudoku
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // Checking if entry is valid
                if (sudoku[i][j] > 0 && !isValidEntry(i, j, sudoku[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    // Function to start solving the sudoku
    public void startSolving() {
        // Checking if sudoku is valid
        if (!isSudokuValid()) {
            System.out.println("Invalid Sudoku");
            return;
        }
        // Start solving the sudoku
        if (solveSudoku(0, 0)) {
            printSudoku();
            return;
        }

        System.out.println("No Possible Solution");
    }

    // Recursive function to start solving the sudoku
    private boolean solveSudoku(int row, int col) {
        // Base Case - When all the rows are covered
        if (row + 1 == size)
            return true;

        // Incrementing the row when all the columns are covered
        if (col == size) {
            row += 1;
            col = 0;
        }

        // If position is prefilled moving forward to next position
        if (sudoku[row][col] > 0) {
            return solveSudoku(row, col + 1);
        }

        // Looping over all the possible entries for a given position
        for (int i = 1; i <= size; i++) {

            // Checking if entry is valid
            if (isValidEntry(row, col, i)) {

                // If entry is valid setting the current position with the entry
                sudoku[row][col] = i;

                // Calling the function with the next position
                // Return true if able to find a valid entry for next position else backtrack
                if (solveSudoku(row, col + 1))
                    return true;

                // Backtracking - Removing the current entry from the current position
                sudoku[row][col] = 0;
            }
        }

        // Return false if not able to find any valid entry for current position
        return false;
    }

    // Function to check if entry is valid for a position
    private boolean isValidEntry(int row, int col, int entry) {

        // Looping over the size of sudoku to check if duplicate entry is present in
        // same row and column
        for (int i = 0; i < size; i++) {

            // Checking if duplicate entry is present in the same row
            if (sudoku[row][i] == entry)
                return false;

            // Checking if duplicate entry is present in the same column
            if (sudoku[i][col] == entry)
                return false;
        }

        // Need to check if duplicate entry is present in the sub-box
        // Getting the starting position of sub-box
        int box_row = Math.abs(row / box_size) * box_size;
        int box_col = Math.abs(col / box_size) * box_size;

        // Looping over the sub-box
        for (int i = box_row; i < (box_row + box_size); i++) {
            for (int j = box_col; j < (box_col + box_size); j++) {

                // Checking if duplicate entry is present in the sub-box
                if (sudoku[i][j] == entry)
                    return false;
            }
        }

        // Return true if no duplicate entry found
        return true;
    }

    // Function to print sudoku
    public void printSudoku() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }
}
