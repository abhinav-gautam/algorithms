import java.util.Arrays;

public class Knapsack {
    int capacity;
    int n_items;
    int[] weights;
    int[] price;
    int[][] knapsackMatrix;

    public Knapsack(int capacity, int n_items, int[] weights, int[] price){
        this.capacity = capacity;
        this.n_items = n_items;
        this.weights = weights;
        this.price = price;
        initKnapsackMatrix();
    }

    public String getItemsList(){
        int[] itemsList = new int[n_items];
        for (int i = 0; i < n_items; i++) {
            itemsList[i]=0;
        }
        int balanceWeight = capacity;
        for (int i = n_items; i >0 ; i--) {
            if (knapsackMatrix[i][balanceWeight] !=0 && knapsackMatrix[i][balanceWeight]!=knapsackMatrix[i-1][balanceWeight]){
                itemsList[i-1] = 1;
                balanceWeight -= weights[i-1];
            }
        }
        return Arrays.toString(itemsList);
    }

    public int findMaxProfit(){
        calculateKnapsackMatrix();
        return knapsackMatrix[n_items][capacity];
    }

    private void calculateKnapsackMatrix(){
        for (int i = 1; i <= n_items; i++) {
            for (int w = 1; w <= capacity; w++) {
                // Item not included
                int notIncluded = knapsackMatrix[i-1][w];

                // Item included
                int included = 0;
                if (w>=weights[i-1]){
                    included = knapsackMatrix[i-1][w-weights[i-1]]+price[i-1];
                }

                // Update matrix
                knapsackMatrix[i][w] = Math.max(notIncluded,included);
            }
        }
    }

    private void initKnapsackMatrix(){
        knapsackMatrix = new int[n_items+1][capacity+1];
        for (int i = 0; i <= n_items; i++) {
            for (int j = 0; j <= capacity; j++) {
                knapsackMatrix[i][j] = 0;
            }
        }
    }

    public void printKnapsackMatrix(){
        for (int i = 0; i <= n_items; i++) {
            for (int j = 0; j <= capacity; j++) {
                System.out.print(knapsackMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
