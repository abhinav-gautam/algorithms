public class Main {
    public static void main(String[] args) {
        String firstString = "acbsdgh";
        String secondString = "aasdvwgf";

        LongestCommonSubsequence lcs = new LongestCommonSubsequence(firstString, secondString);
        lcs.printLcsMatrix();
        System.out.println(lcs.getLcs());
    }
}
