package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Test extends JFrame {
    private static final int[][] name = {{128, 211}, {168, 282}, {208, 212}, {168, 282}, {168, 337}, {220, 335}, {223, 252}, {293, 252}, {291, 326}, {220, 335}, {401, 323}, {335, 325}, {338, 256}, {400, 260}, {400, 245}, {400, 366}, {335, 367}, {503, 329}, {453, 329}, {439, 288}, {474, 247}, {509, 287}, {440, 287}, {507, 287}, {533, 332}, {584, 330}, {584, 300}, {539, 300}, {541, 253}, {587, 253}, {625, 261}, {625, 204}, {625, 332}, {627, 264}, {687, 261}, {687, 334}};
    private static int nameIdx = 0;
    private static int oldX = name[0][0];
    private static int oldY = name[0][1];
    private final DrawingPanel drawingPanel;
    private final Timer timer;

    public Test() {
        setTitle("Random Line Drawer");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBackground(Color.BLACK);

        drawingPanel = new DrawingPanel();
        drawingPanel.setBackground(Color.BLACK);
        add(drawingPanel);

        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                drawingPanel.cercel();
                if (nameIdx < name.length) {
                    drawingPanel.name(oldX, oldY, name[nameIdx][0], name[nameIdx][1]);
                    oldX = name[nameIdx][0];
                    oldY = name[nameIdx][1];
                    nameIdx++;
                } else {

                }
            }
        });
        new Timer(5000, e1 -> {
            nameIdx = 0;
            oldX = name[0][0];
            oldY = name[0][1];
        }).start();
        HashMap<Integer, Integer> old1 = new HashMap<>(Map.of(0, 0, 1, 0, 2, 0, 3, 0));
        HashMap<Integer, Integer> old2 = new HashMap<>(Map.of(0, 800, 1, 0, 2, 800, 3, 0));
        HashMap<Integer, Integer> old3 = new HashMap<>(Map.of(0, 0, 1, 600, 2, 0, 3, 600));
        HashMap<Integer, Integer> old4 = new HashMap<>(Map.of(0, 800, 1, 600, 2, 800, 3, 600));
        new Timer(1, e1 -> {
            for (int i = 0; i < 2; i++) {
                new Thread(() -> {

//            drawingPanel.drawRandomLine2(2);
//                    drawingPanel.drawRandomLine2(4, old1);
                    drawingPanel.drawRandomLine();
//                    drawingPanel.drawRandomLine2(8, old2);
//                    drawingPanel.drawRandomLine2(16, old3);
//                    drawingPanel.drawRandomLine2(32, old4);
//            drawingPanel.drawRandomLine2(64);
//            drawingPanel.drawRandomLine2(128);
//            drawingPanel.drawRandomLine2(256);
//            drawingPanel.drawRandomLine2(512);
                }).start();
            }
        }).start();
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test().setVisible(true);
            }
        });
    }
}

class DrawingPanel extends JPanel {
    public static int oldX = 1;
    public static int oldY = 1;
    public static int cX = 200;
    public static int cY = 200;
    private final Random random;

    public DrawingPanel() {
        random = new Random();
        oldX = 200;
        oldY = 200;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void drawRandomLine() {
        Graphics g = getGraphics();
        int x1 = oldX;
        int y1 = oldY;
        int x2 = random.nextInt(getWidth());
        int y2 = random.nextInt(getHeight());
        oldX = x2;
        oldY = y2;
        g.setColor(new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
        g.drawLine(x1, y1, x2, y2);
        g.dispose();
    }

    public void drawRandomLine2(int move, HashMap<Integer, Integer> old) {
        Graphics g = getGraphics();
        int x1 = old.get(0);
        int y1 = old.get(1);
        int x2;
        int y2;
        if (random.nextBoolean()) {
            x2 = (random.nextBoolean()) ? x1 + move : x1 - move;
            y2 = y1;
        } else {
            y2 = (random.nextBoolean()) ? y1 + move : y1 - move;
            x2 = x1;
        }
        if (x2 < 0) x2 = 0;
        if (x2 > getWidth()) x2 = getWidth();
        if (y2 < 0) y2 = 0;
        if (y2 > getHeight()) y2 = getHeight();
        old.put(0, x2);
        old.put(1, y2);
        g.setColor(new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
        g.drawLine(x1, y1, x2, y2);
//        g.drawLine(x1 + 1, y1 + 1, x2 + 1, y2 + 1);
        g.dispose();
    }

    public void cercel() {
        Graphics g = getGraphics();
        int x = oldX++ + 200;
        int y = (int) Math.sqrt(x) + 200;
        g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        g.drawLine(oldX, oldY, x, y);
        System.out.println(x + " " + y);
        oldY = y;
        g.dispose();
    }

    public void name(int oldX, int oldY, int x, int y) {
        Graphics g = getGraphics();
        g.setColor(Color.WHITE);
        g.drawLine(oldX++, oldY++, x++, y++);
        g.drawLine(oldX++, oldY++, x++, y++);
        g.drawLine(oldX++, oldY++, x++, y++);
        g.drawLine(oldX++, oldY++, x++, y++);
        System.out.println(x + " " + y);
        g.dispose();
    }
}

