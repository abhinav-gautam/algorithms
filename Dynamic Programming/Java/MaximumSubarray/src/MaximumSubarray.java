import java.util.ArrayList;

public class MaximumSubarray {
    int[] array ;
    int size;
    int[][] dpArray;

    public MaximumSubarray(int[] array){
        this.array = array;
        this.size = array.length;
        this.dpArray = new int[size+1][size+1];
        calculateDpArray();
    }

    public ArrayList<Integer> getMaximumSubarray(){
        ArrayList<Integer> maximumSubarray = new ArrayList<>(size);
        int j = size;
        for (int i = size; i >0 ; i--) {
            if (dpArray[i-1][j]!=0 && dpArray[i][j] != dpArray[i-1][j]){
                maximumSubarray.add(array[i-1]);
            }
            j--;
        }
        return maximumSubarray;
    }

    private void calculateDpArray(){
        for (int i = 1; i < size+1; i++) {
            for (int j = 1; j < size+1; j++) {
                int notIncluded = dpArray[i-1][j];
                int included = dpArray[i-1][j];
                if (j>=i){
                    included += array[i-1];
                }
                if (i-2>=0 && dpArray[i-2][j]==dpArray[i-1][j]){
                    included -= dpArray[i-2][j];
                }
                dpArray[i][j] = Math.max(included,notIncluded);
            }
        }
    }

    public void printSolutionArray(){
        for (int i = 0; i < size + 1; i++) {
            for (int j = 0; j < size + 1; j++) {
                System.out.print(dpArray[i][j]+" ");
            }
            System.out.println();
        }
    }
}
