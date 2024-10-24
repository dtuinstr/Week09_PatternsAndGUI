import javax.swing.*;
import java.awt.*;

public class ClackGUI
{
    public ClackGUI() {
        JFrame frame = new JFrame("Clack");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Command Buttons
        JButton fileBtn = new JButton("Send File");
        JButton helpBtn = new JButton("Help");
        JButton listUsersBtn = new JButton("List Users");
        JButton logoutBtn = new JButton("Logout");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2));
        buttonPanel.add(fileBtn);
        buttonPanel.add(listUsersBtn);
        buttonPanel.add(helpBtn);
        buttonPanel.add(logoutBtn);

        // Conversation Panel
        JTextArea textArea = new JTextArea(15, 80);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JPanel conversationPanel = new JPanel();
        conversationPanel.add(scrollPane);

        frame.add(buttonPanel);
        frame.add(conversationPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
