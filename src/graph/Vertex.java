/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author duchi
 */
public class Vertex {

    int radius = 50;
    private int index;//key to search
    private String name;
    private String label;
    private Color color;
    private double x;
    private double y;
    
    public Vertex(int index, String name, String label, Color color, double x, double y) {
        this.index = index;
        this.name = name;
        this.color = color;
        this.label = label;
        this.x = x + radius;
        this.y = y + radius;
    }
    
    public int getIndex() {
        return index;
    }
    
    public void setIndex(int index) {
        this.index = index;
    }
    
    public void draw(Graphics2D gr) {
        
        gr.setColor(Color.WHITE);
        int x1 = (int) (x );
        int y1 = (int) (y);
       
        gr.fill(new Ellipse2D.Double(x1 - radius, y1 - radius, radius * 2, radius));
        //gr.fillOval(x1 - radius, y1 - radius, radius, radius);
        gr.setColor(color);
        //gr.drawOval(x1 - radius, y1 - radius, radius, radius);
        gr.draw(new Ellipse2D.Double(x1 - radius, y1 - radius, radius * 2, radius));

        //gr.drawOval(x1 - radius, y1 - radius, radius+1, radius+1);
        gr.setColor(Color.BLACK);
        gr.drawString(label, x1 - 25, y1 - 25);
        
    }
    
    public String getName() {
        return name;
    }
    
    public String getLabel() {
        return label;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Color getColor() {
        return color;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    
    public double getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x + 50;
    }
    
    public double getY() {
        return y;
    }
    
    public void setY(int y) {
        this.y = y + 50;
    }
    
}
