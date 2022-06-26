public class Main {
    public static void main(String[] args) {
        int [] array = new int[]{-2,-3,4,-1,-2,1,5,-3};
        MaximumSubarray maximumSubarray = new MaximumSubarray(array);
        System.out.println(maximumSubarray.getMaximumSubarray());
        maximumSubarray.printSolutionArray();
    }
}
