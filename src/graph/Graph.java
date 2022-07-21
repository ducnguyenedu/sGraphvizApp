/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author duchi
 */
public class Graph {

    private String name;
    private Set<Vertex> vertices = new HashSet<>();
    private Set<Edge> edges = new HashSet<>();

    public Graph() {

    }

    public Vertex getVertex(String vname) {
        for (Vertex vertice : vertices) {
            if (vertice.getName().equals(vname)) {
                return vertice;
            }
        }
        return null;

    }

    public boolean isNearly(Vertex vertex) {

        if (vertices.size() == 0) {
            return false;
        }
        for (Vertex v : vertices) {
            double dis = Math.sqrt(
                    (vertex.getX() - v.getX()) * (vertex.getX() - v.getX())
                    + (vertex.getY() - v.getY()) * (vertex.getY() - v.getY()));
            System.out.println(dis);
            if (dis < 100) {
                System.out.println(dis);
                return true;
            }
        }
        return false;
    }

    public void draw(Graphics2D g2) {
        for (Edge edge : edges) {
            edge.draw(g2);
        }

        for (Vertex vertice : vertices) {

            vertice.draw(g2);
        }
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(Set<Vertex> vertices) {
        this.vertices = vertices;
    }

    public Set<Edge> getEdges() {
        return edges;
    }

    public void setEdges(Set<Edge> edges) {
        this.edges = edges;
    }
}
