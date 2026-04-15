import javax.swing.*;
import java.awt.*;

public class UserGUI {
    public UserGUI(NotificationSystem system) {
        JFrame frame = new JFrame("YouTube - Subscribe");
        frame.setSize(350, 350);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(24, 24, 24));

        JLabel title = new JLabel("Subscribe to Channel", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setForeground(Color.WHITE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));
        panel.setBackground(new Color(32, 32, 32));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField nameField = new JTextField();
        nameField.setBackground(Color.DARK_GRAY);
        nameField.setForeground(Color.WHITE);

        JCheckBox emailBox = new JCheckBox("Email");
        JCheckBox smsBox = new JCheckBox("SMS");
        JCheckBox appBox = new JCheckBox("App");

        // Style checkboxes
        JCheckBox[] boxes = {emailBox, smsBox, appBox};
        for (JCheckBox box : boxes) {
            box.setBackground(new Color(32, 32, 32));
            box.setForeground(Color.WHITE);
        }

        JButton subscribeBtn = new JButton("Subscribe");
        subscribeBtn.setBackground(new Color(255, 0, 0));
        subscribeBtn.setForeground(Color.WHITE);
        subscribeBtn.setFont(new Font("Arial", Font.BOLD, 14));

        subscribeBtn.addActionListener(e -> {
            String name = nameField.getText();

            User user = new User(
                    name,
                    emailBox.isSelected(),
                    smsBox.isSelected(),
                    appBox.isSelected()
            );

            system.subscribe(user);

            JOptionPane.showMessageDialog(frame, name + " subscribed!");
            nameField.setText("");
        });

        panel.add(new JLabel("Enter Name:", JLabel.LEFT) {{
            setForeground(Color.WHITE);
        }});
        panel.add(nameField);
        panel.add(emailBox);
        panel.add(smsBox);
        panel.add(appBox);

        frame.add(title, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(subscribeBtn, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}