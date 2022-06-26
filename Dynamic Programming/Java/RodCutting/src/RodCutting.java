import java.util.ArrayList;

public class RodCutting {
    int length;
    int[] prices;
    int[][] rodCuttingMatrix;

    public RodCutting(int[] prices){
        this.length = prices.length;
        this.prices = prices;
        initRodCuttingMatrix();
        calculateRodCuttingMatrix();
    }

    public int findMaxProfit(){
        return rodCuttingMatrix[length-1][length];
    }

    public String getPiecesArray(){
        int lengthLeft = length;
        ArrayList<Integer> pieces = new ArrayList<>(length);
        for (int i = length; i >0; i--) {
            if (rodCuttingMatrix[i][lengthLeft]!=0 && rodCuttingMatrix[i][lengthLeft] != rodCuttingMatrix[i-1][lengthLeft]){
                pieces.add(i);
                lengthLeft -= i;
                while (rodCuttingMatrix[i][lengthLeft]!=rodCuttingMatrix[i-1][lengthLeft]){
                    pieces.add(i);
                    lengthLeft -= i;
                }
            }
        }
        return pieces.toString();
    }

    private void initRodCuttingMatrix(){
        rodCuttingMatrix = new int[length+1][length+1];
        for (int i = 0; i < length+1; i++) {
            for (int j = 0; j < length+1; j++) {
                rodCuttingMatrix[i][j] = 0;
            }
        }
    }

    private void calculateRodCuttingMatrix(){
        for (int i = 1; i < length+1; i++) {
            for (int l = 1; l < length+1; l++) {
                // Without cutting
                int withoutCutting = rodCuttingMatrix[i-1][l];
                // With cutting
                int withCutting = rodCuttingMatrix[i-1][l];
                if (l-i>=0){
                    withCutting = rodCuttingMatrix[i][l-i]+prices[i-1];
                }
                rodCuttingMatrix[i][l]=Math.max(withCutting,withoutCutting);
            }
        }
    }

    public void printRodCuttingMatrix(){
        for (int i = 0; i < length+1; i++) {
            for (int j = 0; j < length+1; j++) {
                System.out.print(rodCuttingMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
