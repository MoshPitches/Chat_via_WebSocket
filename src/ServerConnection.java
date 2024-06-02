import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class ServerConnection {
    private WebSocketClient client;
    private List<MessageReceivedListener> messageReceivedListeners;

    public ServerConnection(String serverUrl) {
        messageReceivedListeners = new ArrayList<>();
        try {
            URI serverUri = new URI(serverUrl);
            client = new WebSocketClient(serverUri) {
                @Override
                public void onOpen(ServerHandshake serverHandshake) {
                    System.out.println("Connected to server.");
                }

                @Override
                public void onMessage(String message) {
                    System.out.println("Message received from server: " + message);
                    notifyMessageReceived(message);
                }

                @Override
                public void onClose(int i, String s, boolean b) {
                    System.out.println("Connection closed.");
                }

                @Override
                public void onError(Exception e) {
                    e.printStackTrace();
                }
            };
            client.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message, String source) {
        try {
            if (client != null && client.isOpen()) {
                // Nachricht hier escapen
                message = message.replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t");
                // JSON-Nachricht erstellen, die sowohl die Nachricht als auch den Client enthält
                String jsonMessage = "{\"message\":\"" + message + "\", \"source\":\"" + source + "\"}";
                client.send(jsonMessage);
            } else {
                System.out.println("Client is not connected to the server.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addMessageReceivedListener(MessageReceivedListener listener) {
        messageReceivedListeners.add(listener);
    }

    private void notifyMessageReceived(String message) {
        for (MessageReceivedListener listener : messageReceivedListeners) {
            listener.onMessageReceived(message);
        }
    }
}