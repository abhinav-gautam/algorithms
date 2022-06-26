import java.util.ArrayList;

public class SubsetSum {
    int[] set;
    int setLength;
    int sum;
    boolean[][] subsetMatrix;

    public SubsetSum(int[] set, int sum){
        this.set = set;
        this.sum = sum;
        this.setLength = set.length;
        subsetMatrix = new boolean[setLength+1][sum+1];
        calculateSubsetMatrix();
    }

    public ArrayList<Integer> findSubsetArray(){
        ArrayList<Integer> subset = new ArrayList<>(setLength);
        int balance = sum;
        for (int i = setLength; i > 0; i--) {
            if (subsetMatrix[i][balance]!=subsetMatrix[i-1][balance]){
                subset.add(set[i-1]);
                balance-=set[i-1];
            }
        }
        return subset;
    }

    private void calculateSubsetMatrix(){
        for (int i = 1; i < setLength+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                if (j==set[i-1]){
                    subsetMatrix[i][j] = true;
                }
                if (subsetMatrix[i-1][j]){
                    subsetMatrix[i][j] = true;
                }
                if (j-set[i-1]>0 && subsetMatrix[i-1][j-set[i-1]]){
                    subsetMatrix[i][j] = true;
                }
            }
        }
    }

    public void printSubsetMatrix(){
        for (int i = 0; i < setLength+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                System.out.print(subsetMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
