import javax.swing.*;
import java.awt.*;

public class AdminGUI {
    public AdminGUI(NotificationSystem system) {
        JFrame frame = new JFrame("YouTube - Creator Studio");
        frame.setSize(350, 250);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(24, 24, 24));

        JLabel title = new JLabel("Notify Subscribers", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        title.setForeground(Color.WHITE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1, 10, 10));
        panel.setBackground(new Color(32, 32, 32));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton notifyBtn = new JButton("Notify Subscribers");
        notifyBtn.setBackground(new Color(255, 0, 0));
        notifyBtn.setForeground(Color.WHITE);
        notifyBtn.setFont(new Font("Arial", Font.BOLD, 14));

        notifyBtn.addActionListener(e -> {
            String message = JOptionPane.showInputDialog(frame, "Enter video title:");
            if (message != null && !message.isEmpty()) {
                system.notifyObservers("New Video: " + message);
                JOptionPane.showMessageDialog(frame, "Subscribers Notified!");
            }
        });

        panel.add(new JLabel("Click to notify subscribers:", JLabel.CENTER) {{
            setForeground(Color.WHITE);
        }});
        panel.add(notifyBtn);

        frame.add(title, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}