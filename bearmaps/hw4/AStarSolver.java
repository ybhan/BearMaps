package bearmaps.hw4;

import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.ArrayDeque;


public class AStarSolver<Vertex> {
    private ArrayDeque<Vertex> solution;

    public AStarSolver(AStarGraph<Vertex> input, Vertex start, Vertex end, double timeout) {
        solution = new ArrayDeque<>();
        long startTime = System.currentTimeMillis();

        Map<Vertex, Double> heuristic = new HashMap<>();
        Map<Vertex, Double> distTo = new HashMap<>();
        Map<Vertex, Vertex> edgeTo = new HashMap<>();

        PriorityQueue<Vertex> minPQ = new PriorityQueue<>(
                Comparator.comparingDouble(v -> distTo.get(v) + heuristic.get(v)));
        distTo.put(start, 0.0);
        heuristic.put(start, input.estimatedDistanceToGoal(start, end));
        minPQ.add(start);

        while (minPQ.size() > 0) {
            if (minPQ.peek().equals(end)) {
                Vertex pos = end;
                while (!pos.equals(start)) {
                    solution.addFirst(pos);
                    pos = edgeTo.get(pos);
                }
                solution.addFirst(start);
                return;
            }

            if (System.currentTimeMillis() - startTime > 1000 * timeout) {
                return;
            }

            Vertex curr = minPQ.remove();

            double distToCurr = distTo.get(curr);

            for (WeightedEdge<Vertex> edge : input.neighbors(curr)) {
                if (!heuristic.containsKey(edge.to())) {
                    heuristic.put(edge.to(), input.estimatedDistanceToGoal(edge.to(), end));
                }
                if (!distTo.containsKey(edge.to())
                        || distToCurr + edge.weight() < distTo.get(edge.to())) {
                    distTo.put(edge.to(), distToCurr + edge.weight());
                    edgeTo.put(edge.to(), curr);

                    minPQ.add(edge.to());
                }
            }
        }
    }

    public ArrayDeque<Vertex> solution() {
        return solution;
    }

}
