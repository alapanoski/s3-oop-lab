import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TrafficLight {

    JFrame frame;
    JPanel panel;

    JButton redButton = new JButton("Red");
    JButton yellowButton = new JButton("Yellow");
    JButton greenButton = new JButton("Green");

    Color redColor = Color.black;
    Color yellowColor = Color.black;
    Color greenColor = Color.black;

    JComponent lights = new JComponent() {
        public void paintComponent(Graphics g) {
            g.setColor(Color.white);
            g.fillRect(0, 0, 300, 400);

            g.setColor(redColor);
            g.fillOval(100, 50, 100, 100);
            g.setColor(yellowColor);
            g.fillOval(100, 150, 100, 100);
            g.setColor(greenColor);
            g.fillOval(100, 250, 100, 100);

        }
    };

    TrafficLight() {
        frame = new JFrame("Traffic Light");
        panel = new JPanel();

        frame.setSize(300, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);

        redButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                redColor = Color.red;
                yellowColor = Color.black;
                greenColor = Color.black;
                lights.repaint();
            }

        });
        panel.add(redButton);

        yellowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                redColor = Color.black;
                yellowColor = Color.yellow;
                greenColor = Color.black;
                lights.repaint();
            }

        });
        panel.add(yellowButton);

        greenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                redColor = Color.black;
                yellowColor = Color.black;
                greenColor = Color.green;
                lights.repaint();
            }

        });
        panel.add(greenButton);

        lights.setPreferredSize(new Dimension(300, 400));
        panel.add(lights);
    }

    public static void main(String[] args) {
        new TrafficLight();
    }
}