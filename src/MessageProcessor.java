import org.json.JSONObject;

public class MessageProcessor {

    public String processMessage(String message) {
        try {
            // Nachricht als JSON-Objekt parsen
            JSONObject jsonObject = new JSONObject(message);
            String receivedMessage = jsonObject.getString("message");
            String source = jsonObject.getString("source");
            return source + ": " + receivedMessage;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}