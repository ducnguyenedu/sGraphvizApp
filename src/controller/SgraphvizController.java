/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import graph.DrawShape_SaveAsImage;
import graph.Edge;
import graph.Graph;
import graph.GraphInterpreter;
import graph.Vertex;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import view.Sgraphviz;

/**
 *
 * @author duchi
 */
public class SgraphvizController {

    private Sgraphviz sgraphviz;
    private File fileToSave = null;
    private Graph graph;

    public SgraphvizController() {
        this.sgraphviz = new Sgraphviz();
        sgraphviz.setVisible(true);

        sgraphviz.getBtnVisualize().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizeActionPerformed(evt);
            }

        });
        sgraphviz.getOpenOptionInMenu().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openOptionInMenuActionPerformed(evt);
            }

        });
        sgraphviz.getNewOptionInMenu().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newOptionInMenuActionPerformed(evt);
            }

        });
        sgraphviz.getSaveOptionInMenu().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveOptionInMenuActionPerformed(evt);
            }

        });
        sgraphviz.getBtnSave().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }

        });
    }

    private void paint(Graph graph) {

        Graphics2D g2 = (Graphics2D) sgraphviz.getCanvasGraph().getGraphics();

        g2.setBackground(Color.WHITE);

        g2.clearRect(0, 0, sgraphviz.getCanvasGraph().getWidth(), sgraphviz.getCanvasGraph().getHeight());

        graph.draw(g2);
    }

    private void btnVisualizeActionPerformed(ActionEvent evt) {
        GraphInterpreter interpreter = new GraphInterpreter(sgraphviz.getTxtInput().getText(), sgraphviz.getCanvasGraph().getWidth(), sgraphviz.getCanvasGraph().getHeight());
        this.graph = interpreter.getOutput();
        paint(graph);
        sgraphviz.getTxtLabelGraph().setText("Graph-" + graph.getName());

    }

    private void openOptionInMenuActionPerformed(ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Open");

        int userSelection = fileChooser.showOpenDialog(sgraphviz);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            fileToSave = fileChooser.getSelectedFile();
            fileToSave = fileChooser.getSelectedFile();
            sgraphviz.getPnGraph().removeAll();
            JLabel jl = new JLabel();
            jl.setSize(300, 300);
            jl.setIcon(new ImageIcon(fileToSave.toString()));
            jl.setHorizontalAlignment(JLabel.CENTER);
            sgraphviz.getPnGraph().add(jl);
            sgraphviz.getPnGraph().repaint();
        }
    }

    private void saveOptionInMenuActionPerformed(ActionEvent evt) {
        if (fileToSave == null) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Specify a file to save");

            int userSelection = fileChooser.showSaveDialog(sgraphviz);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                fileToSave = fileChooser.getSelectedFile();

                exportImage();
            }
        } else {
            exportImage();
        }
    }

    public void exportImage() {
        BufferedImage image = new BufferedImage(sgraphviz.getCanvasGraph().getWidth(),
                sgraphviz.getCanvasGraph().getHeight(), BufferedImage.TYPE_INT_RGB);

        Graphics2D graphics = (Graphics2D) image.getGraphics();

        //sgraphviz.getCanvasGraph().paint(graphics);
        graphics.setBackground(Color.WHITE);

        graphics.clearRect(0, 0, sgraphviz.getCanvasGraph().getWidth(), sgraphviz.getCanvasGraph().getHeight());

        graph.draw(graphics);

        try {

            FileOutputStream out = new FileOutputStream(fileToSave);

            ImageIO.write(image, "png", out);

            out.close();
        } catch (IOException ex) {
            Logger.getLogger(SgraphvizController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void newOptionInMenuActionPerformed(ActionEvent evt) {
        this.fileToSave = null;
        sgraphviz.getTxtInput().setText("");
        Graphics2D g2 = (Graphics2D) sgraphviz.getCanvasGraph().getGraphics();

        g2.setBackground(Color.WHITE);

        g2.clearRect(0, 0, sgraphviz.getCanvasGraph().getWidth(), sgraphviz.getCanvasGraph().getHeight());

    }

    private void btnSaveActionPerformed(ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");

        int userSelection = fileChooser.showSaveDialog(sgraphviz);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            fileToSave = fileChooser.getSelectedFile();

            exportImage();
        }
    }
}
