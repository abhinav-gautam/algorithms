public class GraphColoring {
    int[][] adjacencyMatrix;
    int totalVertices;
    int[] nodeColors;

    // Constructor
    public GraphColoring(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.totalVertices = adjacencyMatrix.length;
        initNodeColors();
    }

    // Function to start the graph coloring
    public void startColoring() {

        // Starting the graph coloring
        colorNode(0);

        // Printing the result
        for (int color = 0; color < totalVertices; color++) {
            System.out.println("Node " + color + " - Color " + (nodeColors[color] + 1));
        }
    }

    // Function to initialize the nodeColors matrix with -1
    private void initNodeColors() {

        // Initializing the nodeColors array
        nodeColors = new int[totalVertices];

        // Setting the value to -1
        for (int node = 0; node < totalVertices; node++) {
            nodeColors[node] = -1;
        }
    }

    // Recursive function to color the nodes
    private void colorNode(int node) {

        // Base Case - return when all the nodes are covered
        if (node == totalVertices) {
            return;
        }

        // Finding the color for the current node
        for (int color = 0; color < totalVertices; color++) {

            // If color is valid then come out of the loop
            if (isValidColor(color, node)) {

                // Setting the color for the node
                nodeColors[node] = color;
                break;
            }
        }

        // Call the function with next node
        colorNode(node + 1);
    }

    // Function to check if color is valid for the node
    private boolean isValidColor(int color, int node) {

        // Looping over the adjacent nodes of the given node
        for (int adjacentNode = 0; adjacentNode < adjacencyMatrix[node].length; adjacentNode++) {

            // Return false if adjacent node have the same color as the given node
            if (adjacencyMatrix[node][adjacentNode] > 0 && nodeColors[adjacentNode] == color) {
                return false;
            }
        }
        return true;
    }
}
