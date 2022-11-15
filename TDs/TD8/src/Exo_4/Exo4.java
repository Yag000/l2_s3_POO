package Exo_4;

import java.awt.event.ActionEvent;
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

        JLabel label = new JLabel();
        frame.add(label);
        frame.pack();

        int delay = 1000; // milliseconds
        ActionListener afficheHeure = evt -> {
            System.out.println(LocalTime.now());
            label.setText(String.valueOf(LocalTime.now()));
        };

        Timer t1 = new Timer(delay, afficheHeure);

        delay = 2000; // milliseconds
        ActionListener compterMoutons = new ActionListener() {
            private int last = 0;

            public void actionPerformed(ActionEvent evt) {
                System.out.println(++last);
                label.setText(String.valueOf(last));
            }
        };

        Timer t2 = new Timer(delay, compterMoutons);
        t2.start();

        // Nope, pas de lambda
    }
}
