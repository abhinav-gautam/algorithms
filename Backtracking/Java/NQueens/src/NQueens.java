public class NQueens {

    private final String[][] chessBoard;

    public NQueens(int size){
        this.chessBoard = new String[size][size];

        // Initial the chess board with "-"
        this.initChessBoard();
    }

    // Function to start solving the problem for queen=0 (first queen)
    public void start(){
        if (this.solve(0)){
            this.printBoard();
            return;
        }
        System.out.println("Don't have a possible solution for this board size.");
    }

    // Function to initialize the chess board
    private void initChessBoard(){
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard.length; j++) {
                chessBoard[i][j]="-";
            }
        }
    }

    // Function to check if the current position of queen is valid
    private boolean isValidPosition(int row, int col){
        // Check if any queen is hitting the current position horizontally
        for (int i = 0; i < col; i++) {
            if (this.chessBoard[row][i].equals("Q")){
                return false;
            }
        }

        // Check if any queen is hitting the current position from top-left diagonal
        int tempRow = row;
        for (int i = col; i > -1; i--) {
            if (chessBoard[tempRow][i].equals("Q")){
                return false;
            }
            tempRow--;
            // Break if row reaches the zero
            if (tempRow==-1){
               break;
            }
        }

        // Check if any queen is hitting the current position from bottom-left diagonal
        tempRow = row;
        for (int i = col; i > -1; i--) {
            if (chessBoard[tempRow][i].equals("Q")){
                return false;
            }
            tempRow++;
            // Break if row reaches the end of the board
            if (tempRow==chessBoard.length){
                break;
            }
        }
        // No need to check for vertical as we are not placing the queens in the same column

        // Return true if current position is safe
        return true;
    }

    // Function to find the correct position for all the queens
    private boolean solve(int queen){
        // Return true if all the queens are placed
        if (queen==chessBoard.length){
            return true;
        }

        // Loop to find the safe position for the queen in a column
        for (int i = 0; i < chessBoard.length; i++) {
            // If position is safe then we will place the current queen and call the solve function with the next queen
            if (isValidPosition(i,queen)){
                // Placing the current queen
                chessBoard[i][queen] = "Q";

                // Return true if next queen is also safely placed else we Backtrack
                if (solve(queen+1)){
                    return true;
                }

                // Backtracking - Removing the queen from the current position
                chessBoard[i][queen] = "-";
            }
        }
        // If queens cannot be placed safely return false
        return false;
    }

    // Function to pretty print the chess board
    public void printBoard(){
        for (String[] strings : this.chessBoard) {
            for (int j = 0; j < this.chessBoard.length; j++) {
                System.out.print(strings[j] + "\t");
            }
            System.out.print("\n");
        }
    }
}
