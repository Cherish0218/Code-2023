import java.awt.*;
import java.awt.event.*;
import java.time.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        var clock = new TalkingClock(1000, true);
        clock.start();

        // keep program running until the user selects "OK"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);

    }
}