package org.example;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MainTest {
    private static Main main = new Main();

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void testNoNodeInGraph() {
        DirectedGraph graph = new DirectedGraph();
        graph.addVertex("a");
        List<String> result = main.queryBridgeWords(graph, "a", "b");
        assertNull(result);
    }

    @org.junit.Test
    public void testMultipleBridgeWords() {
        DirectedGraph graph = new DirectedGraph();
        graph.addEdge("a", "c");
        graph.addEdge("a", "d");
        graph.addEdge("c", "b");
        graph.addEdge("d", "b");
        List<String> result = main.queryBridgeWords(graph, "a", "b");
        assertNotNull(result);
        assertTrue(result.containsAll(Arrays.asList("c", "d")));
    }

    @org.junit.Test
    public void testNoBridgeWord1() {
        DirectedGraph graph = new DirectedGraph();
        graph.addEdge("a", "c");
        graph.addEdge("c", "d");
        List<String> result = main.queryBridgeWords(graph, "c", "a");
        assertNull(result);
    }

    @org.junit.Test
    public void testNoBridgeWord2() {
        DirectedGraph graph = new DirectedGraph();
        graph.addEdge("a", "c");
        graph.addEdge("c", "d");
        List<String> result = main.queryBridgeWords(graph, "d", "a");
        assertNull(result);
    }


}