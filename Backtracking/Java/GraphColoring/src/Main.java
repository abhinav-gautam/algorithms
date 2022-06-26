public class Main {
    public static void main(String[] args) {
//        int [][] am = new int[][]{
//                {0,1,1,1,0,0},
//                {1,0,0,1,1,1},
//                {1,0,0,1,1,0},
//                {1,1,1,0,1,0},
//                {0,1,1,1,0,1},
//                {0,1,0,0,1,0},
//        };

        int [][] am = new int[][]{
                {0,1,1,1},
                {1,0,1,0},
                {1,1,0,1},
                {1,0,1,0},
        };

        GraphColoring graphColoring = new GraphColoring(am);
        graphColoring.startColoring();
    }
}
