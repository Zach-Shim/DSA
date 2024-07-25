package bfs;

import edu.washington.cse373.BaseTest;
import org.junit.jupiter.api.Test;

import java.util.*;

public class BFSTests extends BaseTest {

    private Map<String, List<String>> setUpGraph() {
        return Map.of(
            "Disconnected", List.of(),
            "A", List.of("C", "I"),
            "B", List.of("D", "E"),
            "C", List.of("J", "A"),
            "D", List.of("B"),
            "E", List.of("B", "F"),
            "F", List.of("J", "I", "E"),
            "G", List.of("J"),
            "I", List.of("F", "A"),
            "J", List.of("F", "G", "C")
        );
    }

    @Test
    void bfs_disconnectedStart_returnsOnlyDisconnectedVertex() {
        Map<String, List<String>> graph = setUpGraph();
        Map<String, Integer> map = BFS.bfs(graph, "Disconnected");
        assertThat(map).containsOnly(
            entry("Disconnected", 0)
        );
    }

    @Test
    void bfs_aStart_returnFindsStart0DistanceAway() {
        Map<String, List<String>> graph = setUpGraph();
        Map<String, Integer> map = BFS.bfs(graph, "A");
        assertThat(map).contains(
            entry("A", 0)
        );
    }

    @Test
    void bfs_aStart_returnFindsVertices1DistanceAway() {
        Map<String, List<String>> graph = setUpGraph();
        Map<String, Integer> map = BFS.bfs(graph, "A");
        assertThat(map).contains(
            entry("C", 1),
            entry("I", 1)
        );
    }

    @Test
    void bfs_aStart_returnFindsVertices2DistanceAway() {
        Map<String, List<String>> graph = setUpGraph();
        Map<String, Integer> map = BFS.bfs(graph, "A");
        assertThat(map).contains(
            entry("F", 2),
            entry("J", 2)
        );
    }

    @Test
    void bfs_aStart_returnFindsAllVerticesInComponent() {
        Map<String, List<String>> graph = setUpGraph();
        Map<String, Integer> map = BFS.bfs(graph, "A");
        assertThat(map).containsOnly(
            entry("A", 0),
            entry("C", 1),
            entry("I", 1),
            entry("F", 2),
            entry("J", 2),
            entry("G", 3),
            entry("E", 3),
            entry("B", 4),
            entry("D", 5)
        );
    }
}
