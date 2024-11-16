package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CircleDrawer extends JPanel implements ActionListener {
    private Timer timer;
    private double angle = 0;
    private double radius = 0;
    private double angleIncrement = 0.1;
    private double radiusIncrement = 0.5;
    private int centerX;
    private int centerY;
    private int previousX;
    private int previousY;

    public CircleDrawer() {
        setBackground(Color.WHITE);
        timer = new Timer(50, this); // 50 ms delay
        timer.start();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Continuous Spiral Drawer");
        CircleDrawer panel = new CircleDrawer();

        frame.add(panel);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Center of the panel
        centerX = getWidth() / 2;
        centerY = getHeight() / 2;

        // Continue drawing the spiral from the last point
        drawSpiralSegment(g2d);
    }

    private void drawSpiralSegment(Graphics2D g2d) {
        int maxRadius = Math.min(centerX, centerY);

        // Draw the current segment of the spiral
        int x = (int) (centerX + radius * Math.cos(angle));
        int y = (int) (centerY + radius * Math.sin(angle));

        g2d.setColor(Color.BLUE);
        g2d.draw(new Line2D.Double(previousX, previousY, x, y));

        // Update previous point to current point
        previousX = x;
        previousY = y;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Update angle and radius for the next segment
        angle += angleIncrement;
        radius += radiusIncrement;

        // If radius exceeds the maximum, reset for continuous effect
        if (radius > Math.min(centerX, centerY)) {
            angle = 0;
            radius = 0;
            previousX = centerX;
            previousY = centerY;
        }

        // Repaint the panel to draw the next segment
        repaint();
    }
}
