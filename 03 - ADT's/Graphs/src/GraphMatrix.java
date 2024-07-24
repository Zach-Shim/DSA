public class GraphMatrix {

    private int DEFAULT_SIZE = 10;

    private HashSet<Vertex> vertices;
    private HashSet<Edge> edges;

    private Vertex[][] matrix;

    public GraphMatrix() {
        matrix = new Vertex[DEFAULT_SIZE][DEFAULT_SIZE];
    }

    public GraphMatrix(int size) {
        matrix = new Vertex[size][size];
    }

    public GraphMatrix(Vertex[][] matrix) {
        this.matrix = matrix;
    }
    
}