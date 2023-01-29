import java.awt.*;
import java.awt.event.*;
import java.time.*;
import javax.swing.*;


public class Main
{
    public static void main(String[] args)
    {
        var clock = new TalkingClock();
        clock.start(1000,true);

        // keep program running until ther user selects "OK"
        JOptionPane.showMessageDialog(null, "Quit Program?");
        System.exit(0);
    }
}

// a clock that prints the time in regular intervals
class TalkingClock
{
    public void start(int interval, boolean beep)
    {
        var listener = new ActionListener(){
            public void actionPerformed(ActionEvent event)
            {
                System.out.println("At the tone, the time is "
                        + Instant.ofEpochMilli(event.getWhen()));
            }
        };
        var timer = new Timer(interval, listener);
        timer.start();
    }
}