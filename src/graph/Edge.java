/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

/**
 *
 * @author duchi
 */
public class Edge {

    private Vertex from;
    private Vertex to;
    private double range;

    public Edge() {
    }

    public Edge(Vertex from, Vertex to, double range) {
        this.from = from;
        this.to = to;
        this.range = range;
    }

    public void draw(Graphics gr) {
        ElipCaculate mc = new ElipCaculate();
        double x1 = (from.getX());
        double y1 = (from.getY() - 25);
        double x2 = (to.getX());
        double y2 = (to.getY() - 25);
        // (x/h)^2 + (y/v)^2 = 1
        //  y = ax + b
        //double x1, double x2, double y1, double y2, double midX, double midY, double h, double v
        ArrayList<Point2D> point2Ds = mc.getIntersection(x1, x2, y1, y2, x2, y2, 50, 25);
        gr.setColor(Color.BLACK);
        for (Point2D point2D : point2Ds) {
            drawArrowLine(gr, x1, y1, point2D.x, point2D.y, 10, 10);
        }
        //drawArrowLine(gr, x1, y1, x2, y2, 10, 10);
        gr.drawString((int) range + "", (int) (x1 + x2) / 2 + 10, (int) (y1 + y2) / 2 - 5);
        //gr.drawLine((int) x1, (int) y1, (int) x2, (int) y2);

    }

    public Vertex getFrom() {
        return from;
    }

    public void setFrom(Vertex from) {
        this.from = from;
    }

    public Vertex getTo() {
        return to;
    }

    public void setTo(Vertex to) {
        this.to = to;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    private void drawArrowLine(Graphics g, double x1, double y1, double x2, double y2, double d, double h) {

        double dx = x2 - x1, dy = y2 - y1;
        double D = Math.sqrt(dx * dx + dy * dy);
        double xm = D - d, xn = xm, ym = h, yn = -h, x;
        double sin = dy / D, cos = dx / D;

        x = xm * cos - ym * sin + x1;
        ym = xm * sin + ym * cos + y1;
        xm = x;

        x = xn * cos - yn * sin + x1;
        yn = xn * sin + yn * cos + y1;
        xn = x;

        int[] xpoints = {(int) x2, (int) xm, (int) xn};
        int[] ypoints = {(int) y2, (int) ym, (int) yn};

        g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);

        g.fillPolygon(xpoints, ypoints, 3);

    }
    ElipCaculate mc = new ElipCaculate();

    public class Point2D {

        private double x;
        private double y;

        public Point2D(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

    }

    private class ElipCaculate {

        /**
         * (x/h)^2 + (y/v)^2 = 1; y = ax + b ; double x1, double x2, double y1,
         * double y2, double midX, double midY, double h, double v;
         *
         */
        public ArrayList<Point2D> getIntersection(double x1, double x2, double y1, double y2, double midX, double midY, double h, double v) {
            ArrayList<Point2D> points = new ArrayList();

            x1 -= midX;
            y1 -= midY;

            x2 -= midX;
            y2 -= midY;

            if (x1 == x2) {
                double y = (v / h) * Math.sqrt(h * h - x1 * x1);
                if (Math.min(y1, y2) <= y && y <= Math.max(y1, y2)) {
                    points.add(new Point2D(x1 + midX, y + midY));
                }
                if (Math.min(y1, y2) <= -y && -y <= Math.max(y1, y2)) {
                    points.add(new Point2D(x1 + midX, -y + midY));
                }
            } else {
                double a = (y2 - y1) / (x2 - x1);
                double b = (y1 - a * x1);

                double r = a * a * h * h + v * v;
                double s = 2 * a * b * h * h;
                double t = h * h * b * b - h * h * v * v;

                double d = s * s - 4 * r * t;

                if (d > 0) {
                    double xi1 = (-s + Math.sqrt(d)) / (2 * r);
                    double xi2 = (-s - Math.sqrt(d)) / (2 * r);

                    double yi1 = a * xi1 + b;
                    double yi2 = a * xi2 + b;

                    if (isPointInLine(x1, x2, y1, y2, xi1, yi1)) {
                        points.add(new Point2D(xi1 + midX, yi1 + midY));
                    }
                    if (isPointInLine(x1, x2, y1, y2, xi2, yi2)) {
                        points.add(new Point2D(xi2 + midX, yi2 + midY));
                    }
                } else if (d == 0) {
                    double xi = -s / (2 * r);
                    double yi = a * xi + b;

                    if (isPointInLine(x1, x2, y1, y2, xi, yi)) {
                        points.add(new Point2D(xi + midX, yi + midY));
                    }
                }
            }

            return points;
        }

        public boolean isPointInLine(double x1, double x2, double y1, double y2, double px, double py) {
            double xMin = Math.min(x1, x2);
            double xMax = Math.max(x1, x2);

            double yMin = Math.min(y1, y2);
            double yMax = Math.max(y1, y2);

            return (xMin <= px && px <= xMax) && (yMin <= py && py <= yMax);
        }

    }
}
