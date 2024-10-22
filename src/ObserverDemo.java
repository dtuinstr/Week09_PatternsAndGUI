import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ObserverDemo
{
    public static void runDemo() {
        // Build control dialog
        JFrame control = new JFrame("Control");
        control.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        control.setLayout(new FlowLayout());
        JButton helloButton = new JButton("Say Hello");
        JButton goodbyeButton = new JButton("Say Goodbye");
        JButton newAlertButton = new JButton("New Alert");
        control.add(helloButton);
        control.add(goodbyeButton);
        control.add(newAlertButton);
        control.pack();

        // Build Collection of alert boxes
        ArrayList<AlertBox> alerts = new ArrayList<>();
        for (int i = 1; i <= 5; ++i) {
            alerts.add(new AlertBox(
                    "Alert " + i, i * 80, i * 70, "Watch this Space!"));
        }

        // Each box listens for events on hello/goodbye buttons
        for (AlertBox ab : alerts) {
            helloButton.addActionListener(event ->
                    ab.setText("Hello, world!"));
            goodbyeButton.addActionListener(event ->
                    ab.setText("Good-bye, world."));
        }

        // Attach a listener to newAlert button
        newAlertButton.addActionListener(event ->
        {
            AlertBox ab = new AlertBox(
                    "NEW Alert", 100, 100, "Watch this space too");
            alerts.addLast(ab);
            ab.setVisible(true);
            helloButton.addActionListener(e ->
                    ab.setText("Hello, new world!"));
            goodbyeButton.addActionListener(e ->
                    ab.setText("Goodbye, new world"));
        });

        // do the demo
        for (AlertBox ab : alerts) {
            ab.setVisible(true);
        }
        control.setVisible(true);
    }
}
