import java.util.ArrayList;

public class HamiltonianCycle {
    int[][] adjacencyMatrix;
    ArrayList<ArrayList<Integer>> edgeMatrix;
    ArrayList<Integer> cycleArray;

    // Constructor
    public HamiltonianCycle(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.edgeMatrix = new ArrayList<>(adjacencyMatrix.length);
        this.cycleArray = new ArrayList<>(adjacencyMatrix.length);
        this.initEdgeMatrix();
    }

    // Function to start finding the Hamiltonion Cycle
    public void start() {

        // Start the from first node
        if (findCycle(0)) {
            System.out.println(cycleArray);
            return;
        }
        System.out.println("Cycle does not exists");
    }

    // Recursive function to find the hamiltonion cycle
    private boolean findCycle(int start) {

        // Base case - When all the nodes are covered
        if (cycleArray.size() == adjacencyMatrix.length) {

            // Check if all the nodes in the path form a cycle
            // Check if theres a path from last node to the first node
            if (edgeMatrix.get(cycleArray.get(cycleArray.size() - 1)).contains(cycleArray.get(0))) {

                // Add the first node again to form a cycle
                cycleArray.add(cycleArray.get(0));
                return true;
            }
            return false;
        }

        // Looping over all the adjacent nodes of the current node to find the
        // appropriate path
        for (int i = 0; i < edgeMatrix.get(start).size(); i++) {

            // Considering the adjacent node which has not been added to the path
            if (!cycleArray.contains(edgeMatrix.get(start).get(i))) {

                // Add the adjacent node to the path
                cycleArray.add(edgeMatrix.get(start).get(i));

                // Call the function again
                // Return true if success, otherwise backtrack
                if (findCycle(edgeMatrix.get(start).get(i))) {
                    return true;
                }

                // Backtracking - Remove the last added adjacent node
                cycleArray.remove(cycleArray.size() - 1);
            }
        }

        // Return false if not able to find any appropriate node
        return false;
    }

    // Function to initialize edgeMatrix
    // edgeMatrix contains only adjacent nodes for each nodes
    private void initEdgeMatrix() {

        // Looping over the adjacency matrix
        for (int i = 0; i < adjacencyMatrix.length; i++) {

            // Initializing a new array for adjacent nodes
            edgeMatrix.add(new ArrayList<>(adjacencyMatrix.length));

            // Looping over the adjacent nodes and adding them to list
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                if (adjacencyMatrix[i][j] > 0) {
                    edgeMatrix.get(i).add(j);
                }
            }
        }
    }

    // Function to print the edgeMatrix
    public void printEdgeMatrix() {
        for (int i = 0; i < edgeMatrix.size(); i++) {
            System.out.println(i + "->" + edgeMatrix.get(i));
        }
    }
}
