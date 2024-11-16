package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpinningCube extends JFrame implements ActionListener {
    private final Timer timer;
    private double angleX = 0;
    private double angleY = 0;
    private double[][][] vertices;
    private int[][] edges;

    public SpinningCube() {
        setTitle("3D Rotating Rubik's Cube");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Timer to update the cube rotation
        timer = new Timer(100, this);
        timer.start();

        // Define cube vertices
        vertices = new double[27][8][3];
        int index = 0;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    vertices[index++] = new double[][]{
                            {x - 0.5, y - 0.5, z - 0.5}, {x + 0.5, y - 0.5, z - 0.5},
                            {x - 0.5, y + 0.5, z - 0.5}, {x + 0.5, y + 0.5, z - 0.5},
                            {x - 0.5, y - 0.5, z + 0.5}, {x + 0.5, y - 0.5, z + 0.5},
                            {x - 0.5, y + 0.5, z + 0.5}, {x + 0.5, y + 0.5, z + 0.5}
                    };
                }
            }
        }

        // Define edges
        edges = new int[][]{
                {0, 1}, {1, 3}, {3, 2}, {2, 0},
                {4, 5}, {5, 7}, {7, 6}, {6, 4},
                {0, 4}, {1, 5}, {2, 6}, {3, 7}
        };
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SpinningCube frame = new SpinningCube();
            frame.setVisible(true);
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Center of the screen
        int cx = getWidth() / 2;
        int cy = getHeight() / 2;

        // Scale factor
        int scale = 100;

        // Rotate and project the cube vertices
        for (double[][] cube : vertices) {
            double[][] rotated = new double[8][3];
            for (int i = 0; i < cube.length; i++) {
                double[] v = cube[i];
                double x = v[0], y = v[1], z = v[2];

                // Rotate around X axis
                double tmpY = y * Math.cos(angleX) - z * Math.sin(angleX);
                double tmpZ = y * Math.sin(angleX) + z * Math.cos(angleX);
                y = tmpY;
                z = tmpZ;

                // Rotate around Y axis
                double tmpX = x * Math.cos(angleY) + z * Math.sin(angleY);
                z = -x * Math.sin(angleY) + z * Math.cos(angleY);
                x = tmpX;

                rotated[i][0] = x;
                rotated[i][1] = y;
                rotated[i][2] = z;
            }

            // Draw edges
            g2d.setColor(Color.BLUE);
            for (int[] edge : edges) {
                double[] v1 = rotated[edge[0]];
                double[] v2 = rotated[edge[1]];

                int x1 = (int) (cx + v1[0] * scale);
                int y1 = (int) (cy + v1[1] * scale);
                int x2 = (int) (cx + v2[0] * scale);
                int y2 = (int) (cy + v2[1] * scale);

                g2d.drawLine(x1, y1, x2, y2);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        angleX += 0.1;
        angleY += 0.1;
        repaint();
    }
}
