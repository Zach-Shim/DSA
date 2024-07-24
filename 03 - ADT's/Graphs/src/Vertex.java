public class Vertex {

    private boolean visited;

    public Vertex() {

    }

    // Returns if this Vertex has been visited
    public boolean isVisited() {
        return this.visited;
    }

    // Marks this vertex as visited (visited = true)
    public void setVisited() {
        this.visited = true;
    }
}