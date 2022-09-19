import javax.swing.*;
import java.awt.*;

public class TerminalWindow extends JPanel {
    JTextField textField;
    public TerminalWindow() {
        textField = new JTextField(1);
        add(textField);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.textField.setLocation(0, 0);
        this.textField.setSize(500, 25);
//        System.out.println(this.textField.getText());
    }
}
