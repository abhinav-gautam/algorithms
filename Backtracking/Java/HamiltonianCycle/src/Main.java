public class Main {
    public static void main(String[] args) {
        int [][] am = new int[][]{
                {0,1,1,1,0,0},
                {1,0,0,1,1,1},
                {1,0,0,1,1,0},
                {1,1,1,0,1,0},
                {0,1,1,1,0,1},
                {0,1,0,0,1,0},
        };

        HamiltonianCycle hamiltonianCycle = new HamiltonianCycle(am);
        hamiltonianCycle.start();
    }
}
