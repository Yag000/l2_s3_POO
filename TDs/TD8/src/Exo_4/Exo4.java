package Exo_4;

import java.awt.event.ActionListener;

import java.time.LocalTime;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Exo4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Relief Valve");
        frame.setResizable(false);
        frame.setLocation(500, 300);
        JLabel label = new JLabel("this is my text");
        frame.add(label);
        frame.pack();

        int delay = 1000; // milliseconds
        ActionListener afficheHeure = evt -> System.out.println(LocalTime.now());

        Timer t1 = new Timer(delay, afficheHeure);

        t1.start();
    }
}
