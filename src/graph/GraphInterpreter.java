/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.awt.Color;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.swing.JOptionPane;

/**
 *
 * @author duchi
 */
public class GraphInterpreter {

    private String input;
    private Graph output;
    private HashMap<String, Pair<String, String>> verticesData = new HashMap<>();
    private Vector<Pair<String, Pair<String, String>>> edgesData = new Vector<>();
    private int x;
    private int y;

    public GraphInterpreter(String input, int x, int y) {
        this.input = input.trim();
        this.x = x;
        this.y = y;
        translateToGraph();
    }

    public void setInput(String input) {
        this.input = input.trim();
        translateToGraph();
    }

    public Graph getOutput() {
        return output;
    }

    public void setOutput(Graph output) {
        this.output = output;
    }

    private void translateToGraph() {

        String name = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '{') {
                break;
            }
            name += input.charAt(i);
        }
        this.output = new Graph();
        output.setName(name);
        StringTokenizer st = new StringTokenizer(input, "\n");
        int countLine = 0;
        //loop all line of snippet code to read information
        while (st.hasMoreTokens()) {
            String temp = st.nextToken();
            temp = temp.trim();
            countLine++;
            if (temp.length() > 2 && temp.substring(0, 2).equals("//")) {
                continue;
            }
            //a line is about vertice if has label and color
            if (temp.contains("label") && temp.contains("color")) {
                addVerticeData(countLine, temp);
            } //a line is about edge if has label
            else if (temp.contains("label")) {
                addEdgeData(countLine, temp);
            } else {
                //not valid line
                if (temp.length() != 0 && !temp.contains(output.getName()) && !temp.equals("}")) {
                    String er = "Line " + countLine + ""
                            + "\nInvalid syntax: " + temp
                            + "\nJust enter 2 syntax:\n"
                            + " vertice_name[label=\"{NOT_BLANK}\", color=\"{NOT_BLANK}\"}"
                            + "\n vertice->vertice[label=\"{NOT_BLANK}\"\n}";
                    JOptionPane.showMessageDialog(null, er);
                }
            }
        }
        int index = 0;
        int x1 = 0;
        int y1 = 0;
        int x2 = 20;
        int y2 = 200;
        int x3 = 150;
        int y3 = 20;

        for (Map.Entry<String, Pair<String, String>> entry : verticesData.entrySet()) {
            String key = entry.getKey();
            Pair<String, String> value = entry.getValue();
            Random r = new Random();

            Color c = Color.BLACK;
            final Field f;
            try {
                f = Color.class.getField(value.getValue().toUpperCase());
                c = (Color) f.get(null);

                Vertex vertice = new Vertex(index, key, value.getKey(), c,
                        index == 0 ? x1 : index == 1 ? x2 : index == 2 ? x3 : r.nextInt(x - 50),
                        index == 0 ? y1 : index == 1 ? y2 : index == 2 ? y3 : r.nextInt(y - 50));
                boolean isInfinityLoop = false;
                int count = 0;
                while (output.isNearly(vertice) && !isInfinityLoop) {
                    vertice = new Vertex(index, key, value.getKey(), c,
                            r.nextInt(150),
                            r.nextInt(200));

                    count++;
                    if (count > 50) {
                        isInfinityLoop = true;
                    }
                }
                index++;
                output.getVertices().add(vertice);
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(GraphInterpreter.class.getName()).log(Level.SEVERE, null, ex);
                String er = value.getValue() + " is Wrong";
                JOptionPane.showMessageDialog(null, er);
            } catch (SecurityException ex) {
                Logger.getLogger(GraphInterpreter.class.getName()).log(Level.SEVERE, null, ex);
                String er = value.getValue() + " is Wrong";
                JOptionPane.showMessageDialog(null, er);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(GraphInterpreter.class.getName()).log(Level.SEVERE, null, ex);
                String er = value.getValue() + " is Wrong";
                JOptionPane.showMessageDialog(null, er);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(GraphInterpreter.class.getName()).log(Level.SEVERE, null, ex);
                String er = value.getValue() + " is Wrong";
                JOptionPane.showMessageDialog(null, er);
            }

        }
        for (Pair element : edgesData) {
            String u = (String) element.getKey();
            Pair temp = (Pair) element.getValue();
            String v = (String) temp.getKey();

            String label = (String) temp.getValue();
            if (output.getVertex(u) != null && output.getVertex(v) != null) {
                Edge edge = new Edge(output.getVertex(u), output.getVertex(v), Integer.parseInt(label));
                output.getEdges().add(edge);
                System.out.println(u + " " + v + " " + label);
            } else {
                JOptionPane.showMessageDialog(null, "Vertex not found");
            }
        }
    }

    private void addVerticeData(int countLine, String verticeData) {
        boolean startLabel = false;
        boolean startColor = false;
        boolean startName = false;
        String labelVertice = "", nameVertice = "", colorVertice = "";
        StringTokenizer st = new StringTokenizer(verticeData, "\t\"=,[]\' ");

        while (st.hasMoreTokens()) {
            String temp = st.nextToken();
            System.out.println(temp);
            if (!startName) {
                nameVertice = temp;
                startName = true;
                continue;
            }
            try {
                if (!startLabel && temp.contains("label")) {
                    labelVertice = st.nextToken();
                    startLabel = true;
                    System.out.println(labelVertice);
                    if (!startColor && labelVertice.contains("color")) {
                        labelVertice="";
                        colorVertice = st.nextToken();
                        System.out.println(colorVertice);
                        startColor = true;
                        Color color = null;

                        Field field = Class.forName("java.awt.Color").getField(colorVertice);
                        color = (Color) field.get(null);
                        break;
                    }
                    continue;
                }
                if (!startColor && temp.contains("color")) {
                    colorVertice = st.nextToken();
                    System.out.println(colorVertice);
                    startColor = true;
                    Color color = null;

                    Field field = Class.forName("java.awt.Color").getField(colorVertice);
                    color = (Color) field.get(null);
                    continue;
                }
            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e);

            }
        }
        verticesData.put(nameVertice, new Pair<>(labelVertice, colorVertice));
    }

    private void addEdgeData(int countLine, String edgeData) {
        StringTokenizer st = new StringTokenizer(edgeData, "\t\"->[]=, ");
       
        String u = "", v = "", label = "";
        //read information from string after split
        while (st.hasMoreTokens()) {
            String temp = st.nextToken();
            if (u.compareTo("") == 0) {
                u = temp;
                continue;
            }
            if (v.compareTo("") == 0) {
                v = temp;
                continue;
            }
            try {
                if (temp.contains("label")) {
                    label = st.nextToken();
                    break;
                }
            } catch (Exception e) {
                String er = "Line " + countLine + "\n"
                        + "Your input propertise is blank.\n"
                        + "Just input vertice->vertice["
                        + "label=\"{NOT_BLANK}\"]";
                JOptionPane.showMessageDialog(null, er);
            }

        }
        Pair pair1 = new Pair(v, label);
        edgesData.add(new Pair(u, pair1));
    }
}
