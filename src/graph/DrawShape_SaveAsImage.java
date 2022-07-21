/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author duchi
 */
import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class DrawShape_SaveAsImage extends Canvas {

    public static void main(String[] args) {
        JFrame f = new JFrame("Draw shape and text on Canvas");
        final Canvas canvas = new DrawShape_SaveAsImage();

        f.add(canvas);

        f.setSize(
                300, 300);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent event) {
                saveCanvas(canvas);
                System.exit(0);

            }

        });
    }

    @Override
    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setBackground(Color.WHITE);

        g2.clearRect(0, 0, this.getWidth(), this.getHeight());
        g2.setColor(Color.BLACK);

        g2.drawString(
                "Draw a rectangle", 100, 100);
        g2.drawRect(
                100, 200, 50, 50);
    }

    public static void saveCanvas(Canvas canvas) {
        BufferedImage image = new BufferedImage(canvas.getWidth(), canvas.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) image.getGraphics();

        canvas.paint(g2);

        try {
            ImageIO.write(image, "png ", new File("c:\\temp\\canvas.png"));
        } catch (Exception e) {
        }
    }
}
