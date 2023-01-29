import java.awt.*;
import java.awt.event.*;
import java.time.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        var listener = new TimePrinter();

        // construct a timer that calls the listener once every second
        var timer = new Timer(1000, listener);
        timer.start();
        String
        // keep program running until the users selects "ok"
        JOptionPane.showMessageDialog(null,"Quit program? ");
        System.exit(0);
    }
}