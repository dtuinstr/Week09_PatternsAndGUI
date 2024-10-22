import javax.swing.*;
import java.awt.*;

/**
 * Wrap a JTextField-containing JFrame so that external
 * objects can easily change the text in the JTextField.
 */
public class AlertBox extends JFrame
{
    JTextField textField;

    AlertBox(String title, int x, int y, String msg)
    {
        super(title);
        setLocation(x, y);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        textField = new JTextField(30);
        textField.setText(msg);
        add(textField);

        pack();
        setVisible(true);
    }

    public void setText(String msg)
    {
        textField.setText(msg);
    }
}
