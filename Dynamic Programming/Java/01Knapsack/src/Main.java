public class Main {
    public static void main(String[] args) {
        int capacity = 8;
        int n_items = 5;
        int[] weights = new int[]{5,4,6,2,1};
        int[] price = new int[]{10,5,15,17,5};

        Knapsack knapsack = new Knapsack(capacity,n_items,weights,price);
        System.out.println(knapsack.findMaxProfit());
        System.out.println(knapsack.getItemsList());
        knapsack.printKnapsackMatrix();
    }
}
