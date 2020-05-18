package bearmaps.hw4.streetmap;

import bearmaps.proj2ab.Point;

/**
 * Vertex representation for the graph.
 *
 * @author Kevin Lowe, Yuanbo Han
 */
public class Node extends Point {
    private long id;
    private String name;

    private Node(long id, double lat, double lon) {
        super(lon, lat);
        this.id = id;
    }

    public static Node of(long id, double lat, double lon) {
        return new Node(id, lat, lon);
    }

    public long id() {
        return id;
    }

    public double lat() {
        return getY();
    }

    public double lon() {
        return getX();
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Node)) {
            return false;
        }
        Node otherNode = (Node) other;
        return this.id == otherNode.id();
    }

    @Override
    public int hashCode() {
        return (int) this.id;
    }

    @Override
    public String toString() {
        return String.format("Node id: %d, lat: %.10f, lon: %.10f", id(), lat(), lon());
    }
}
