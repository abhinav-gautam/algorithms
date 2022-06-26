public class Main {
    public static void main(String[] args) {
        int[] prices = new int[]{1, 5, 8, 9, 10, 17, 17, 20};

        RodCutting rodCutting = new RodCutting(prices);
        System.out.println(rodCutting.getPiecesArray());
        System.out.println(rodCutting.findMaxProfit());
        rodCutting.printRodCuttingMatrix();
    }
}
