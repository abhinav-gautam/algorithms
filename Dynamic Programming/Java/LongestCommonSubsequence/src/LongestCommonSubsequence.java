public class LongestCommonSubsequence {
    String firstString;
    String secondString;
    int firsStringLength;
    int secondStringLength;

    int[][] lcsMatrix;

    public LongestCommonSubsequence(String firstString, String secondString){
        this.firstString = firstString;
        this.secondString = secondString;
        this.firsStringLength = firstString.length();
        this.secondStringLength = secondString.length();
        lcsMatrix = new int[firsStringLength+1][secondStringLength+1];
        calculateLcsMatrix();
    }

    public String getLcs(){
        int i = firsStringLength;
        int j = secondStringLength;
        StringBuilder lcsBuilder = new StringBuilder();
        while (i>0 && j>0){
            if (firstString.substring(i-1,i).equals(secondString.substring(j-1,j))){
                lcsBuilder.append(firstString, i-1, i);
                i--;
                j--;
            }else if (lcsMatrix[i-1][j]>lcsMatrix[i][j-1]){
                i--;
            }else{
                j--;
            }
        }
        return lcsBuilder.reverse().toString();
    }

    private void calculateLcsMatrix(){
        for (int i = 1; i < firsStringLength+1; i++) {
            for (int j = 1; j < secondStringLength+1; j++) {
                if (firstString.substring(i - 1,i).equals(secondString.substring(j - 1,j))){
                    lcsMatrix[i][j] = lcsMatrix[i-1][j-1]+1;
                }else{
                    lcsMatrix[i][j] = Math.max(lcsMatrix[i-1][j],lcsMatrix[i][j-1]);
                }
            }
        }
    }

    public void printLcsMatrix(){
        for (int i = 0; i < firsStringLength+1; i++) {
            for (int j = 0; j < secondStringLength+1; j++) {
                System.out.print(lcsMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }

}
