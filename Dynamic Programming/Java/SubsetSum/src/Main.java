public class Main {
    public static void main(String[] args) {
        int[] subset = new int[]{5,2,1,3};
        int sum = 9;

        SubsetSum subsetSum = new SubsetSum(subset,sum);
        System.out.println(subsetSum.findSubsetArray());
        subsetSum.printSubsetMatrix();
    }
}
