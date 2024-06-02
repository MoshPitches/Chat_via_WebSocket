import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JavaClientGUI {
    private ServerConnection serverConnection;
    private JTextArea chatArea, messageField;
    public String source = "Kenneth";

    public JavaClientGUI(ServerConnection serverConnection) {
        this.serverConnection = serverConnection;
        serverConnection.addMessageReceivedListener(new MessageReceivedListener() {
            @Override
            public void onMessageReceived(String message) {
                processMessage(message);
            }
        });
    }

    private void createAndShowGUI() {
        Image appIcon = Toolkit.getDefaultToolkit().getImage("appIcon.ico");
        JFrame frame = new JFrame("Java Chat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(appIcon);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        JScrollPane chatScrollPane = new JScrollPane(chatArea);
        panel.add(chatScrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        messageField = new JTextArea();
        messageField.setLineWrap(true);
        inputPanel.add(messageField, BorderLayout.CENTER);

        JButton sendButton = new JButton();
        ImageIcon sendIcon = new ImageIcon("sendIcon.png");
        sendButton.setIcon(sendIcon);
        inputPanel.add(sendButton, BorderLayout.EAST);

        // Enter Taste
        messageField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }
        });

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        panel.add(inputPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
        messageField.requestFocusInWindow();
    }

    private void sendMessage() {
        String message = messageField.getText();
        if (!message.trim().isEmpty()) {
            serverConnection.sendMessage(message.trim(), source);
            messageField.setText("");
        }
    }

    private void appendMessage(String message) {
        chatArea.append(message + "\n"); // Nachrichten chronologisch hinzufügen
    }

    private void processMessage(String message) {
        MessageProcessor processor = new MessageProcessor();
        String formattedMessage = processor.processMessage(message);
        if (formattedMessage != null) {
            appendMessage(formattedMessage);
        }
    }

    public static void main(String[] args) {
        String serverUrl = "ws://192.168.178.88:3001"; // IP-Adresse des Servers anpassen
        ServerConnection serverConnection = new ServerConnection(serverUrl);
        JavaClientGUI clientGUI = new JavaClientGUI(serverConnection);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                clientGUI.createAndShowGUI();
            }
        });
    }
}